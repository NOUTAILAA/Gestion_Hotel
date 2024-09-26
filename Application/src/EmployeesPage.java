import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeesPage extends Application {

    private TableView<TeamSchedule> tableView;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employés ");

        VBox employeeLayout = new VBox(10);

        // Create the update button
        Button backButton = Utils.createBackButton(primaryStage);

        // Create the table view
        tableView = createTableView();

        // Create the update button
        Button updateButton = new Button("Mettre à jour");
        updateButton.setOnAction(e -> updateSchedule());

        Button detailsButton = new Button("Voir Détails Équipes");
        detailsButton.setOnAction(e -> showDetailsInterface());

        // Ajouter le TableView à VBox
        employeeLayout.getChildren().addAll(backButton, tableView);

        // Ajouter les boutons après le TableView
        employeeLayout.getChildren().addAll(detailsButton, updateButton);

        Scene employeeScene = new Scene(employeeLayout, 600, 400);
        primaryStage.setScene(employeeScene);
        primaryStage.show();
    }



    private void showDetailsInterface() {
        DetailsEquipesPage.showDetailsEquipesInterface();
	}



	public static void showEmployeesInterface(Stage primaryStage) {
        EmployeesPage employeesPage = new EmployeesPage();
        employeesPage.start(primaryStage);
    }


    private TableView<TeamSchedule> createTableView() {
        TableView<TeamSchedule> table = new TableView<>();
        table.setEditable(true);

        // Créer les colonnes
        TableColumn<TeamSchedule, String> dayColumn = new TableColumn<>("Jour");
        dayColumn.setCellValueFactory(cellData -> cellData.getValue().dayProperty());

        TableColumn<TeamSchedule, Boolean> team1Column = createTeamColumn("Équipe 1", "team1");
        TableColumn<TeamSchedule, Boolean> team2Column = createTeamColumn("Équipe 2", "team2");
        TableColumn<TeamSchedule, Boolean> team3Column = createTeamColumn("Équipe 3", "team3");
        TableColumn<TeamSchedule, Boolean> team4Column = createTeamColumn("Équipe 4", "team4");
        TableColumn<TeamSchedule, Boolean> team5Column = createTeamColumn("Équipe 5", "team5");

        table.getColumns().addAll(dayColumn, team1Column, team2Column, team3Column, team4Column, team5Column);

        // Ajouter des données d'exemple
        ObservableList<TeamSchedule> data = FXCollections.observableArrayList(
                new TeamSchedule("Lundi"),
                new TeamSchedule("Mardi"),
                new TeamSchedule("Mercredi"),
                new TeamSchedule("Jeudi"),
                new TeamSchedule("Vendredi"),
                new TeamSchedule("Samedi"),
                new TeamSchedule("Dimanche")
        );

        table.setItems(data);

        return table;
    }

    private TableColumn<TeamSchedule, Boolean> createTeamColumn(String columnName, String propertyName) {
        TableColumn<TeamSchedule, Boolean> column = new TableColumn<>(columnName);
        column.setCellValueFactory(cellData -> cellData.getValue().getTeam(propertyName));
        column.setCellFactory(CheckBoxTableCell.forTableColumn(column));
        column.setEditable(true);
        return column;
    }

    private void updateSchedule() {
        // Vérifier si plus d'une équipe est sélectionnée pour un jour donné
        for (TeamSchedule teamSchedule : tableView.getItems()) {
            int selectedTeams = 0;

            if (teamSchedule.getTeam("team1").get()) selectedTeams++;
            if (teamSchedule.getTeam("team2").get()) selectedTeams++;
            if (teamSchedule.getTeam("team3").get()) selectedTeams++;
            if (teamSchedule.getTeam("team4").get()) selectedTeams++;
            if (teamSchedule.getTeam("team5").get()) selectedTeams++;

            if (selectedTeams > 1) {
                // Afficher une boîte de dialogue d'erreur
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText(null);
                alert.setContentText("Plus d'une équipe ne peut pas travailler en même temps pour " + teamSchedule.getDay() + ".");
                alert.showAndWait();
                return; // Arrêter la mise à jour car une erreur a été détectée
            }
        }

        // Si aucune erreur n'a été détectée, confirmer la mise à jour
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Mise à jour effectuée avec succès.");

        alert.showAndWait();
        // Exporter vers CSV après la confirmation
        CsvExporter.exportToCsv(tableView.getItems(), "schedule.csv");
    }

    public static class TeamSchedule {
        private final String day;
        private final BooleanProperty team1 = new SimpleBooleanProperty(false);
        private final BooleanProperty team2 = new SimpleBooleanProperty(false);
        private final BooleanProperty team3 = new SimpleBooleanProperty(false);
        private final BooleanProperty team4 = new SimpleBooleanProperty(false);
        private final BooleanProperty team5 = new SimpleBooleanProperty(false);

        public TeamSchedule(String day) {
            this.day = day;
        }

        public String getDay() {
            return day;
        }

        public BooleanProperty getTeam(String teamName) {
            switch (teamName) {
                case "team1":
                    return team1;
                case "team2":
                    return team2;
                case "team3":
                    return team3;
                case "team4":
                    return team4;
                case "team5":
                    return team5;
                default:
                    throw new IllegalArgumentException("Invalid team name: " + teamName);
            }
        }
       

        
        public StringProperty dayProperty() {
            return new SimpleStringProperty(day);
        }
    }
}
