import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingUtilities;

public class LoginPage {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "1234";
    private static final String DB_URL = "jdbc:sqlite:C:/Users/nouta/eclipse-workspace/Application/myappP.db";
    private static final String DB_USER = "nouta";
    private static final String DB_PASSWORD = "111";

    public static void showLogin(Stage primaryStage) {
        primaryStage.setTitle("NOUTIYAFH HOTEL");

        VBox loginLayout = new VBox(10);
        loginLayout.setPadding(new javafx.geometry.Insets(30));
        loginLayout.setStyle("-fx-background-color: rgb(255, 255, 255); -fx-box-shadow: 0px 0px 40px rgba(0, 0, 0, 0.062);");

        Label headingLabel = new Label("NOUTIYAFH HOTEL");
        headingLabel.getStyleClass().add("heading");

        VBox usernameContainer = createInputContainer("Username", "username");
        VBox passwordContainer = createInputContainer("Password", "password");

        Button loginButton = new Button("Login");
        loginButton.setId("button");
        loginButton.setOnAction(e -> handleLogin(usernameContainer, passwordContainer, primaryStage));

        

        loginLayout.getChildren().addAll(headingLabel, usernameContainer, passwordContainer, loginButton);

        Scene loginScene = new Scene(loginLayout, 300, 300);
        loginScene.getStylesheets().add(LoginPage.class.getResource("styles.css").toExternalForm()); // Link the CSS file
        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private static VBox createInputContainer(String prompt, String id) {
        VBox inputContainer = new VBox();
        inputContainer.getStyleClass().add("inputContainer");

        Label icon = new Label();
        icon.getStyleClass().add("inputIcon");

        if (prompt.equals("Password")) {
            PasswordField inputField = new PasswordField();
            inputField.getStyleClass().add("inputField");
            inputField.setId(id);
            inputField.setPromptText(prompt);

            inputContainer.getChildren().addAll(icon, inputField);
        } else {
            TextField inputField = new TextField();
            inputField.getStyleClass().add("inputField");
            inputField.setId(id);
            inputField.setPromptText(prompt);

            inputContainer.getChildren().addAll(icon, inputField);
        }

        return inputContainer;
    }


    private static void handleLogin(VBox usernameContainer, VBox passwordContainer, Stage primaryStage) {
        String username = ((TextField) usernameContainer.getChildren().get(1)).getText();
        String password = ((TextField) passwordContainer.getChildren().get(1)).getText();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            EmployeePage.showEmployeeInterface(primaryStage);
         
        } else if (username.equals("Equipe1") && password.equals("11111")) {
            // Display Equipe1 interface
            SwingUtilities.invokeLater(() -> new Equipe1());
        } else if (username.equals("Equipe2") && password.equals("22222")) {
            // Display Equipe1 interface
            SwingUtilities.invokeLater(() -> new Equipe2());
        }
        else if (username.equals("Equipe3") && password.equals("33333")) {
            // Display Equipe1 interface
            SwingUtilities.invokeLater(() -> new Equipe3());
        }else if (username.equals("Equipe4") && password.equals("44444")) {
            // Display Equipe1 interface
            SwingUtilities.invokeLater(() -> new Equipe4());
        }else if (username.equals("Equipe5") && password.equals("55555")) {
            // Display Equipe1 interface
            SwingUtilities.invokeLater(() -> new Equipe5());
        }else if (login(username, password)) {
            // Afficher l'interface si le login est réussi
            SuccessPage.showSuccessInterface(primaryStage);
        } else {
            showAlert("Login Failed", "Invalid username or password.");
        }
    }

    private static boolean login(String username, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                return resultSet.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
