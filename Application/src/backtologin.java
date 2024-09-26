import javafx.scene.control.Button;
import javafx.stage.Stage;






public class backtologin {
    public static void showLoginInterface(Stage primaryStage) {
        LoginPage.showLogin(primaryStage);
    }

    public static Button createBackButton(Stage primaryStage) {
        Button backButton = new Button("<<");
        backButton.setOnAction(e -> showLoginInterface(primaryStage));
        return backButton;
    }

}