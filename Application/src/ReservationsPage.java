import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationsPage {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bdbd3";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1234";
    private static TableView<Reservation> tableView;

    public static void showReservationsInterface(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Réservations");

  
            VBox reservationsLayout = new VBox(10);

            // Remove the local declaration of TableView<Reservation> tableView
            tableView = new TableView<>();
        // Creating the columns

        TableColumn<Reservation, String> cinColumn = new TableColumn<>("CIN");
        TableColumn<Reservation, String> nomClientColumn = new TableColumn<>("Nom du Client");
        TableColumn<Reservation, String> dateDebutColumn = new TableColumn<>("Date Début");
        TableColumn<Reservation, String> dateFinColumn = new TableColumn<>("Date Fin");
        TableColumn<Reservation, Integer> nbrChambresColumn = new TableColumn<>("Nombre de Chambres");
        TableColumn<Reservation, String> typeChambreColumn = new TableColumn<>("Type de Chambre");

        // Associating properties of the Reservation class with the columns
       
        cinColumn.setCellValueFactory(cellData -> cellData.getValue().CinProperty());
        nomClientColumn.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
        dateDebutColumn.setCellValueFactory(cellData -> cellData.getValue().dateDebutProperty());
        dateFinColumn.setCellValueFactory(cellData -> cellData.getValue().dateFinProperty());
        nbrChambresColumn.setCellValueFactory(cellData -> cellData.getValue().nbrChambresProperty().asObject());
        typeChambreColumn.setCellValueFactory(cellData -> cellData.getValue().typeChambreProperty());

        // Adding columns to the table
        tableView.getColumns().addAll( cinColumn, nomClientColumn, dateDebutColumn, dateFinColumn, nbrChambresColumn, typeChambreColumn);

        // Retrieving data from the database
        ObservableList<Reservation> reservationsData = getReservationsFromDatabase();

        // Setting the items in the table
        tableView.setItems(reservationsData);

        Button backButton = new Button("<<");
        backButton.setOnAction(e -> EmployeePage.showEmployeeInterface(primaryStage));

        Button addReservationButton = new Button("Add Reservation");
        addReservationButton.setOnAction(e -> showAddReservationDialog(primaryStage));
        
        Button modifyReservationButton = new Button("Modifier Reservation");
        modifyReservationButton.setOnAction(e -> showModifyReservationDialog(primaryStage));
        Button deleteReservationButton = new Button("Supprimer Reservation");
        deleteReservationButton.setOnAction(e -> showDeleteConfirmationDialog(primaryStage));
        


        Scene reservationsScene = new Scene(reservationsLayout, 800, 600);
        primaryStage.setScene(reservationsScene);
        primaryStage.show();
        TextField searchCinField = new TextField();
        searchCinField.setPromptText("Rechercher par CIN");
        Button searchButton = new Button("Rechercher");
        searchButton.setOnAction(e -> {
            String searchCin = searchCinField.getText();
            ObservableList<Reservation> filteredReservations = getFilteredReservations(searchCin);
            tableView.setItems(filteredReservations);
        });
        reservationsLayout.getChildren().addAll(backButton, searchCinField, searchButton, tableView, addReservationButton, modifyReservationButton, deleteReservationButton);

    }


    // Method to retrieve reservations from the database
    private static ObservableList<Reservation> getReservationsFromDatabase() {
        ObservableList<Reservation> reservationsData = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT  cin , nomclient, date_debut, date_fin, nbr_chambres, type_chambre FROM reservations";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    
                    String cin = resultSet.getString("cin");
                    String nomClient = resultSet.getString("nomclient");
                    String dateDebut = resultSet.getString("date_debut");
                    String dateFin = resultSet.getString("date_fin");
                    int nbrChambres = resultSet.getInt("nbr_chambres");
                    String typeChambre = resultSet.getString("type_chambre");

                    Reservation reservation = new Reservation(cin , nomClient, dateDebut, dateFin, nbrChambres, typeChambre);
                    reservationsData.add(reservation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservationsData;
    }
    private static void showAddReservationDialog(Stage primaryStage) {
        Stage addReservationStage = new Stage();
        addReservationStage.setTitle("Add Reservation");

        VBox addReservationLayout = new VBox(10);

        // Create input fields for reservation details
        TextField cinField = new TextField();
        TextField nomClientField = new TextField();
        TextField dateDebutField = new TextField();
        TextField dateFinField = new TextField();
        TextField nbrChambresField = new TextField();
        TextField typeChambreField = new TextField();

        // Create a button to submit the new reservation
        Button submitButton = new Button("Add Reservation");
        submitButton.setOnAction(e -> {
            // Get values from input fields
            String cin = cinField.getText();
            String nomClient = nomClientField.getText();
            String dateDebut = dateDebutField.getText();
            String dateFin = dateFinField.getText();
            int nbrChambres = Integer.parseInt(nbrChambresField.getText());
            String typeChambre = typeChambreField.getText();

            // Validate input (you can add more validation if needed)

            // Insert the new reservation into the database
            insertReservationIntoDatabase(cin, nomClient, dateDebut, dateFin, nbrChambres, typeChambre);

            // Close the dialog
            addReservationStage.close();

            // Refresh the reservations table
            tableView.setItems(getReservationsFromDatabase());
        });

        addReservationLayout.getChildren().addAll(
                new Label("CIN: "), cinField,
                new Label("Nom du Client: "), nomClientField,
                new Label("Date Début: "), dateDebutField,
                new Label("Date Fin: "), dateFinField,
                new Label("Nombre de Chambres: "), nbrChambresField,
                new Label("Type de Chambre: "), typeChambreField,
                submitButton);

        Scene addReservationScene = new Scene(addReservationLayout, 400, 300);
        addReservationStage.setScene(addReservationScene);
        addReservationStage.show();
    }

    private static void insertReservationIntoDatabase(String cin, String nomClient, String dateDebut, String dateFin, int nbrChambres, String typeChambre) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO reservations (cin, nomclient, date_debut, date_fin, nbr_chambres, type_chambre) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, cin);
                preparedStatement.setString(2, nomClient);
                preparedStatement.setString(3, dateDebut);
                preparedStatement.setString(4, dateFin);
                preparedStatement.setInt(5, nbrChambres);
                preparedStatement.setString(6, typeChambre);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle the exception (show an error message, log, etc.)
        }
    }
    private static void showModifyReservationDialog(Stage primaryStage) {
        // Vérifiez si une réservation est sélectionnée dans le tableau
        Reservation selectedReservation = tableView.getSelectionModel().getSelectedItem();

        if (selectedReservation == null) {
            // Aucune réservation sélectionnée, affichez un message d'erreur
            showAlert(Alert.AlertType.ERROR, "Erreur", "Aucune réservation sélectionnée",
                    "Veuillez sélectionner une réservation à modifier.");
            return;
        }

        Stage modifyReservationStage = new Stage();
        modifyReservationStage.setTitle("Modifier Reservation");

        VBox modifyReservationLayout = new VBox(10);

        // Utilisez des champs de texte et pré-remplissez-les avec les détails de la réservation sélectionnée
        TextField cinField = new TextField(selectedReservation.getCin());
        TextField nomClientField = new TextField(selectedReservation.getNomClient());
        TextField dateDebutField = new TextField(selectedReservation.getDateDebut());
        TextField dateFinField = new TextField(selectedReservation.getDateFin());
        TextField nbrChambresField = new TextField(String.valueOf(selectedReservation.getNbrChambres()));
        TextField typeChambreField = new TextField(selectedReservation.getTypeChambre());

        // Créez un bouton pour soumettre la modification
        Button submitButton = new Button("Modifier Reservation");
        submitButton.setOnAction(e -> {
            // Obtenez les valeurs des champs de texte
            String cin = cinField.getText();
            String nomClient = nomClientField.getText();
            String dateDebut = dateDebutField.getText();
            String dateFin = dateFinField.getText();
            int nbrChambres = Integer.parseInt(nbrChambresField.getText());
            String typeChambre = typeChambreField.getText();

            // Validez les entrées si nécessaire

            // Mettez à jour la réservation dans la base de données
            updateReservationInDatabase( cin, nomClient, dateDebut, dateFin, nbrChambres, typeChambre);

            // Fermez la boîte de dialogue de modification
            modifyReservationStage.close();

            // Actualisez le tableau des réservations
            tableView.setItems(getReservationsFromDatabase());
        });

        modifyReservationLayout.getChildren().addAll(
                new Label("CIN: "), cinField,
                new Label("Nom du Client: "), nomClientField,
                new Label("Date Début: "), dateDebutField,
                new Label("Date Fin: "), dateFinField,
                new Label("Nombre de Chambres: "), nbrChambresField,
                new Label("Type de Chambre: "), typeChambreField,
                submitButton);

        Scene modifyReservationScene = new Scene(modifyReservationLayout, 400, 300);
        modifyReservationStage.setScene(modifyReservationScene);
        modifyReservationStage.show();
    }
    private static ObservableList<Reservation> getFilteredReservations(String searchCin) {
        ObservableList<Reservation> reservationsData = getReservationsFromDatabase().filtered(reservation -> reservation.matchesCin(searchCin));
        return reservationsData;
    }


    private static void updateReservationInDatabase( String cin, String nomClient, String dateDebut, String dateFin, int nbrChambres, String typeChambre) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "UPDATE reservations SET cin=?, nomclient=?, date_debut=?, date_fin=?, nbr_chambres=?, type_chambre=? WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, cin);
                preparedStatement.setString(2, nomClient);
                preparedStatement.setString(3, dateDebut);
                preparedStatement.setString(4, dateFin);
                preparedStatement.setInt(5, nbrChambres);
                preparedStatement.setString(6, typeChambre);
        

                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Gérez l'exception (affichez un message d'erreur, journalisez, etc.)
        }
    }

    private static void showAlert(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }
    private static void showDeleteConfirmationDialog(Stage primaryStage) {
        // Vérifiez si une réservation est sélectionnée dans le tableau
        Reservation selectedReservation = tableView.getSelectionModel().getSelectedItem();

        if (selectedReservation == null) {
            // Aucune réservation sélectionnée, affichez un message d'erreur
            showAlert(Alert.AlertType.ERROR, "Erreur", "Aucune réservation sélectionnée",
                    "Veuillez sélectionner une réservation à supprimer.");
            return;
        }

        // Affichez une boîte de dialogue de confirmation
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Confirmation de suppression");
        confirmationDialog.setHeaderText("Supprimer la réservation ?");
        confirmationDialog.setContentText("Voulez-vous vraiment supprimer cette réservation ?");
        confirmationDialog.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                
                // Actualisez le tableau des réservations
                tableView.setItems(getReservationsFromDatabase());
            }
        });
    }

    // Ajoutez cette méthode pour supprimer une réservation de la base de données
    private static void deleteReservationFromDatabase(int reservationId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "DELETE FROM reservations WHERE id=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, reservationId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Gérez l'exception (affichez un message d'erreur, journalisez, etc.)
        }
    }
}


