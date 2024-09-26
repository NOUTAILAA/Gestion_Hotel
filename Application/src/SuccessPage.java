// SuccessPage.java
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SuccessPage {
    public static void showSuccessInterface(Stage primaryStage) {
        primaryStage.setTitle("Success");

        VBox successLayout = new VBox(10);

        Label successLabel = new Label("Ce compte existe ! Aucune info pour le moment !!!! ");
        successLayout.getChildren().add(successLabel);

        Scene successScene = new Scene(successLayout, 300, 200);
        primaryStage.setScene(successScene);
        primaryStage.show();
    }
}