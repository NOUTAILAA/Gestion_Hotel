
import javafx.scene.control.Button;

import javafx.stage.Stage;

public class Utils {
    public static void showMainInterface(Stage primaryStage) {
        EmployeePage.showEmployeeInterface(primaryStage);
    }

    public static Button createBackButton(Stage primaryStage) {
        Button backButton = new Button("<<");
        backButton.setOnAction(e -> showMainInterface(primaryStage));
        return backButton;
    }
}
