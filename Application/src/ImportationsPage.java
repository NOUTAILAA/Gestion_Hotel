import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ImportationsPage {
    public static void showImportationsInterface(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Importations");

        VBox importationsLayout = new VBox(10);

        // Ajoutez ici la logique pour gérer les importations

        Button backButton = new Button("Retour");
        backButton.setOnAction(e -> EmployeePage.showEmployeeInterface(primaryStage));

        importationsLayout.getChildren().add(Utils.createBackButton(primaryStage));

        Scene importationsScene = new Scene(importationsLayout, 600, 400);
        primaryStage.setScene(importationsScene);
        primaryStage.show();
    }
}
