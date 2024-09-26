import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class DetailsEquipesPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Détails Équipes");

        VBox detailsLayout = new VBox(10);

        // Ajoutez les composants de l'interface des détails d'équipes
        Label detailsLabel = new Label("Détails Équipes");

        // Créez une TableView pour afficher les employés
        TableView<Employe> tableView = createTableView();

        // Ajoutez des boutons "Ajouter Employé", "Modifier Employé" et "Supprimer Employé"
        Button addButton = new Button("Ajouter Employé");
        Button editButton = new Button("Modifier Employé");
        Button deleteButton = new Button("Supprimer Employé");

        addButton.setOnAction(event -> showAddEmployeDialog(tableView));
        editButton.setOnAction(event -> showEditEmployeDialog(tableView));
        deleteButton.setOnAction(event -> showDeleteEmployeDialog(tableView));

        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addButton, editButton, deleteButton);

        detailsLayout.getChildren().addAll(detailsLabel, tableView, buttonBox);

        Scene detailsScene = new Scene(detailsLayout, 800, 600);
        primaryStage.setScene(detailsScene);
        primaryStage.show();
    }

    public static void showDetailsEquipesInterface() { 
    	DetailsEquipesPage detailsEquipesPage = new DetailsEquipesPage(); 
    	detailsEquipesPage.start(new Stage()); 
    }

    private TableView<Employe> createTableView() {
        TableView<Employe> tableView = new TableView<>();

        // Créez les colonnes de la table
        TableColumn<Employe, Integer> idCol = new TableColumn<>("ID");
        TableColumn<Employe, String> cinCol = new TableColumn<>("CIN");
        TableColumn<Employe, String> nomCol = new TableColumn<>("Nom");
        TableColumn<Employe, String> prenomCol = new TableColumn<>("Prénom");
        TableColumn<Employe, Integer> numEquipeCol = new TableColumn<>("Num. Équipe");
        TableColumn<Employe, String> posteCol = new TableColumn<>("Poste");
        TableColumn<Employe, String> telephoneCol = new TableColumn<>("Téléphone");

        // Associez les propriétés des objets Employe aux colonnes
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        cinCol.setCellValueFactory(new PropertyValueFactory<>("cin"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        numEquipeCol.setCellValueFactory(new PropertyValueFactory<>("numEquipe"));
        posteCol.setCellValueFactory(new PropertyValueFactory<>("poste"));
        telephoneCol.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        // Ajoutez les colonnes à la TableView
        tableView.getColumns().addAll(idCol, cinCol, nomCol, prenomCol, numEquipeCol, posteCol, telephoneCol);

        // Chargez les données depuis la base de données
        loadTableData(tableView);

        return tableView;
    }

    private void loadTableData(TableView<Employe> tableView) {
        try {
            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/bdbd3";
            String utilisateur = "root";
            String motDePasse = "1234";

            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Créer la requête SQL pour récupérer toutes les lignes de la table employe
            String requeteSQL = "SELECT * FROM employe";

            // Créer l'instruction SQL
            Statement statement = connexion.createStatement();

            // Exécuter la requête et récupérer le résultat dans la TableView
            ResultSet resultSet = statement.executeQuery(requeteSQL);
            while (resultSet.next()) {
                Employe employe = new Employe(
                        resultSet.getInt("id"),
                        resultSet.getString("cin"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getInt("num_equipe"),
                        resultSet.getString("poste"),
                        resultSet.getString("telephone")
                );
                tableView.getItems().add(employe);
            }

            // Fermer les ressources
            //statement.close();
           // connexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAddEmployeDialog(TableView<Employe> tableView) {
        // Créez des champs de texte pour les informations de l'employé
        TextField cinField = new TextField();
        TextField nomField = new TextField();
        TextField prenomField = new TextField();
        TextField equipeField = new TextField();
        TextField posteField = new TextField();
        TextField telephoneField = new TextField();

        // Créez une boîte de dialogue pour saisir les informations de l'employé
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Ajouter Employé");
        dialog.setHeaderText("Veuillez saisir les informations de l'employé.");

        // Ajoutez les champs de texte à la boîte de dialogue
        dialog.getDialogPane().setContent(new VBox(8, cinField, nomField, prenomField, equipeField, posteField, telephoneField));

        // Ajoutez des boutons OK et Annuler à la boîte de dialogue
        ButtonType addButton = new ButtonType("Ajouter", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButton, ButtonType.CANCEL);

        // Définissez le résultat du bouton OK
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButton) {
                return "Ajouter";
            }
            return null;
        });

        // Affichez la boîte de dialogue et traitez les résultats
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(action -> {
            if (action.equals("Ajouter")) {
                // Récupérez les valeurs des champs de texte
                String cin = cinField.getText();
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                int equipe = Integer.parseInt(equipeField.getText());
                String poste = posteField.getText();
                String telephone = telephoneField.getText();

                // Ajoutez l'employé à la base de données et rafraîchissez le tableau
                addEmployeToDatabase(cin, nom, prenom, equipe, poste, telephone);
                loadTableData(tableView);
            }
        });
    }

    private void addEmployeToDatabase(String cin, String nom, String prenom, int equipe, String poste, String telephone) {
        try {
            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/bdbd3";
            String utilisateur = "root";
            String motDePasse = "1234";

            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Créer la requête SQL pour insérer un nouvel employé
            String requeteSQL = "INSERT INTO employe (cin, nom, prenom, num_equipe, poste, telephone) " +
                    "VALUES ('" + cin + "', '" + nom + "', '" + prenom + "', " + equipe + ", '" + poste + "', '" + telephone + "')";

            // Créer l'instruction SQL
            Statement statement = connexion.createStatement();

            // Exécuter la requête
            statement.executeUpdate(requeteSQL);

            // Fermer les ressources
            //statement.close();
            //connexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void showEditEmployeDialog(TableView<Employe> tableView) {
        // Récupérez l'employé sélectionné dans le tableau
        Employe selectedEmploye = tableView.getSelectionModel().getSelectedItem();

        if (selectedEmploye == null) {
            // Aucun employé sélectionné, affichez un message d'erreur
            showAlert("Aucun employé sélectionné", "Veuillez sélectionner un employé à modifier.");
            return;
        }

        // Créez des champs de texte pré-remplis avec les informations de l'employé
        TextField cinField = new TextField(selectedEmploye.getCin());
        TextField nomField = new TextField(selectedEmploye.getNom());
        TextField prenomField = new TextField(selectedEmploye.getPrenom());
        TextField equipeField = new TextField(String.valueOf(selectedEmploye.getNumEquipe()));
        TextField posteField = new TextField(selectedEmploye.getPoste());
        TextField telephoneField = new TextField(selectedEmploye.getTelephone());

        // Créez une boîte de dialogue pour modifier les informations de l'employé
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Modifier Employé");
        dialog.setHeaderText("Veuillez modifier les informations de l'employé.");

        // Ajoutez les champs de texte à la boîte de dialogue
        dialog.getDialogPane().setContent(new VBox(8, cinField, nomField, prenomField, equipeField, posteField, telephoneField));

        // Ajoutez des boutons OK et Annuler à la boîte de dialogue
        ButtonType editButton = new ButtonType("Modifier", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(editButton, ButtonType.CANCEL);

        // Définissez le résultat du bouton OK
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == editButton) {
                return "Modifier";
            }
            return null;
        });

        // Affichez la boîte de dialogue et traitez les résultats
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(action -> {
            if (action.equals("Modifier")) {
                // Récupérez les nouvelles valeurs des champs de texte
                String newCin = cinField.getText();
                String newNom = nomField.getText();
                String newPrenom = prenomField.getText();
                int newEquipe = Integer.parseInt(equipeField.getText());
                String newPoste = posteField.getText();
                String newTelephone = telephoneField.getText();

                // Modifiez l'employé dans la base de données et rafraîchissez le tableau
                editEmployeInDatabase(selectedEmploye.getId(), newCin, newNom, newPrenom, newEquipe, newPoste, newTelephone);
                loadTableData(tableView);
            }
        });
    }

    private void editEmployeInDatabase(int employeId, String newCin, String newNom, String newPrenom, int newEquipe, String newPoste, String newTelephone) {
        try {
            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/bdbd3";
            String utilisateur = "root";
            String motDePasse = "1234";

            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Créer la requête SQL pour mettre à jour les informations de l'employé
            String requeteSQL = "UPDATE employe SET cin = '" + newCin + "', nom = '" + newNom + "', prenom = '" + newPrenom +
                    "', num_equipe = " + newEquipe + ", poste = '" + newPoste + "', telephone = '" + newTelephone + "' WHERE id = " + employeId;

            // Créer l'instruction SQL
            Statement statement = connexion.createStatement();

            // Exécuter la requête
            statement.executeUpdate(requeteSQL);

            // Fermer les ressources
            statement.close();
            connexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDeleteEmployeDialog(TableView<Employe> tableView) {
        // Récupérez l'employé sélectionné dans le tableau
        Employe selectedEmploye = tableView.getSelectionModel().getSelectedItem();

        if (selectedEmploye == null) {
            // Aucun employé sélectionné, affichez un message d'erreur
            showAlert("Aucun employé sélectionné", "Veuillez sélectionner un employé à supprimer.");
            return;
        }

        // Affichez une boîte de dialogue de confirmation pour la suppression
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Êtes-vous sûr de vouloir supprimer cet employé ?");
        alert.setContentText(selectedEmploye.getNom() + " " + selectedEmploye.getPrenom());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Supprimez l'employé de la base de données et rafraîchissez le tableau
            deleteEmployeFromDatabase(selectedEmploye.getId());
            loadTableData(tableView);
        }
    }

    private void deleteEmployeFromDatabase(int employeId) {
        try {
            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/bdbd3";
            String utilisateur = "root";
            String motDePasse = "1234";

            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Créer la requête SQL pour supprimer l'employé
            String requeteSQL = "DELETE FROM employe WHERE id = " + employeId;

            // Créer l'instruction SQL
            Statement statement = connexion.createStatement();

            // Exécuter la requête
            statement.executeUpdate(requeteSQL);

            // Fermer les ressources
            statement.close();
            connexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // La classe Employe avec des propriétés correspondantes
    public static class Employe {
        private int id;
        private String cin;
        private String nom;
        private String prenom;
        private int numEquipe;
        private String poste;
        private String telephone;

        public Employe(int id, String cin, String nom, String prenom, int numEquipe, String poste, String telephone) {
            this.id = id;
            this.cin = cin;
            this.nom = nom;
            this.prenom = prenom;
            this.numEquipe = numEquipe;
            this.poste = poste;
            this.telephone = telephone;
        }

        // Ajoutez les getters pour chaque propriété
        public int getId() {
            return id;
        }

        public String getCin() {
            return cin;
        }

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public int getNumEquipe() {
            return numEquipe;
        }

        public String getPoste() {
            return poste;
        }

        public String getTelephone() {
            return telephone;
        }
    }
}
