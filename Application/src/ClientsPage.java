import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Optional;

public class ClientsPage extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bdbd3";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        showClientsInterface(primaryStage);
    }

    public static void showClientsInterface(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Clients");

        VBox clientsLayout = new VBox(10);

        TableView<Client> tableView = new TableView<>();



        TableColumn<Client, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Client, String> cinColumn = new TableColumn<>("CIN");
        TableColumn<Client, String> nomColumn = new TableColumn<>("Nom");
        TableColumn<Client, String> prenomColumn = new TableColumn<>("Prénom");
        TableColumn<Client, String> emailColumn = new TableColumn<>("Email");
        TableColumn<Client, String> telephoneColumn = new TableColumn<>("Téléphone");

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        cinColumn.setCellValueFactory(cellData -> cellData.getValue().cinProperty());
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        telephoneColumn.setCellValueFactory(cellData -> cellData.getValue().telephoneProperty());

        tableView.getColumns().addAll(idColumn, cinColumn, nomColumn, prenomColumn, emailColumn, telephoneColumn);

        tableView.getItems().addAll(fetchClientsData());

        TextField searchField = new TextField();
        searchField.setPromptText("Rechercher par nom/prénom");

        Button searchButton = new Button("Rechercher");
        searchButton.setOnAction(e -> searchClient(tableView, searchField.getText()));

        Button deleteButton = new Button("Supprimer Client");
        deleteButton.setOnAction(e -> deleteClient(tableView));

        Button addButton = new Button("Ajouter Client");
        addButton.setOnAction(e -> addClient(tableView));

        Button editButton = new Button("Modifier Client");
        editButton.setOnAction(e -> editClient(tableView));

        clientsLayout.getChildren().addAll(
                Utils.createBackButton(primaryStage),
                searchField, searchButton, tableView, deleteButton, addButton, editButton
        );

        Scene clientsScene = new Scene(clientsLayout, 600, 400);
        primaryStage.setScene(clientsScene);
        primaryStage.show();
    }

    private static ObservableList<Client> fetchClientsData() {
        ObservableList<Client> clientsList = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String cin = resultSet.getString("cin");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String email = resultSet.getString("email");
                String telephone = resultSet.getString("telephone");

                clientsList.add(new Client(id, cin, nom, prenom, email, telephone));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientsList;
    }

    private static void searchClient(TableView<Client> tableView, String searchQuery) {
        ObservableList<Client> filteredList = fetchClientsData().filtered(client ->
                client.getNom().toLowerCase().contains(searchQuery.toLowerCase()) ||
                        client.getPrenom().toLowerCase().contains(searchQuery.toLowerCase()));

        tableView.getItems().setAll(filteredList);
    }

    private static void deleteClient(TableView<Client> tableView) {
        Client selectedClient = tableView.getSelectionModel().getSelectedItem();

        if (selectedClient != null) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                // Retrieve the IDs of the clients to be updated
                PreparedStatement retrieveIdsStatement = connection.prepareStatement("SELECT id FROM client ORDER BY id");
                ResultSet resultSet = retrieveIdsStatement.executeQuery();
                
                // Use a counter for the new ID
                int newId = 1;

                // Iterate through the clients, update the ID, and then delete the selected client
                while (resultSet.next()) {
                    int currentId = resultSet.getInt("id");
                    if (currentId == selectedClient.getId()) {
                        // Skip the selected client for deletion
                        continue;
                    }

                    // Update the ID
                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE client SET id = ? WHERE id = ?");
                    updateStatement.setInt(1, newId);
                    updateStatement.setInt(2, currentId);
                    updateStatement.executeUpdate();

                    newId++;
                }

                // Finally, delete the selected client
                PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM client WHERE id = ?");
                deleteStatement.setInt(1, selectedClient.getId());
                deleteStatement.executeUpdate();

                tableView.getItems().remove(selectedClient);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void addClient(TableView<Client> tableView) {
        Client newClient = showAddClientDialog();
        if (newClient != null) {
            saveClientToDatabase(newClient);
            tableView.getItems().setAll(fetchClientsData());
        }
    }

    private static void editClient(TableView<Client> tableView) {
        Client selectedClient = tableView.getSelectionModel().getSelectedItem();
        if (selectedClient != null) {
            Client updatedClient = showEditClientDialog(selectedClient);
            if (updatedClient != null) {
                updateClientInDatabase(updatedClient);
                tableView.getItems().setAll(fetchClientsData());
            }
        }
    }

    private static Client showAddClientDialog() {
        Dialog<Client> dialog = new Dialog<>();
        dialog.setTitle("Ajouter Client");
        dialog.setHeaderText("Entrez les informations du nouveau client");

        ButtonType addButton = new ButtonType("Ajouter", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField cinField = new TextField();
        TextField nomField = new TextField();
        TextField prenomField = new TextField();
        TextField emailField = new TextField();
        TextField telephoneField = new TextField();

        grid.add(new Label("CIN:"), 0, 0);
        grid.add(cinField, 1, 0);
        grid.add(new Label("Nom:"), 0, 1);
        grid.add(nomField, 1, 1);
        grid.add(new Label("Prénom:"), 0, 2);
        grid.add(prenomField, 1, 2);
        grid.add(new Label("Email:"), 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(telephoneField, 1, 4);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return new Client(
                        0,
                        cinField.getText(),
                        nomField.getText(),
                        prenomField.getText(),
                        emailField.getText(),
                        telephoneField.getText()
                );
            }
            return null;
        });

        Optional<Client> result = dialog.showAndWait();
        return result.orElse(null);
    }

    private static Client showEditClientDialog(Client clientToEdit) {
        Dialog<Client> dialog = new Dialog<>();
        dialog.setTitle("Modifier Client");
        dialog.setHeaderText("Modifiez les informations du client");

        ButtonType editButton = new ButtonType("Modifier", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(editButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        TextField cinField = new TextField(clientToEdit.getCin());
        TextField nomField = new TextField(clientToEdit.getNom());
        TextField prenomField = new TextField(clientToEdit.getPrenom());
        TextField emailField = new TextField(clientToEdit.getEmail());
        TextField telephoneField = new TextField(clientToEdit.getTelephone());

        grid.add(new Label("CIN:"), 0, 0);
        grid.add(cinField, 1, 0);
        grid.add(new Label("Nom:"), 0, 1);
        grid.add(nomField, 1, 1);
        grid.add(new Label("Prénom:"), 0, 2);
        grid.add(prenomField, 1, 2);
        grid.add(new Label("Email:"), 0, 3);
        grid.add(emailField, 1, 3);
        grid.add(new Label("Téléphone:"), 0, 4);
        grid.add(telephoneField, 1, 4);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == editButton) {
                return new Client(
                        clientToEdit.getId(),
                        cinField.getText(),
                        nomField.getText(),
                        prenomField.getText(),
                        emailField.getText(),
                        telephoneField.getText()
                );
            }
            return null;
        });

        Optional<Client> result = dialog.showAndWait();
        return result.orElse(null);
    }

    private static void saveClientToDatabase(Client client) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO client (cin, nom, prenom, email, telephone) VALUES (?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, client.getCin());
            preparedStatement.setString(2, client.getNom());
            preparedStatement.setString(3, client.getPrenom());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getTelephone());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateClientInDatabase(Client client) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE client SET cin=?, nom=?, prenom=?, email=?, telephone=? WHERE id=?")) {

            preparedStatement.setString(1, client.getCin());
            preparedStatement.setString(2, client.getNom());
            preparedStatement.setString(3, client.getPrenom());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getTelephone());
            preparedStatement.setInt(6, client.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}