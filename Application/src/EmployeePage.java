import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmployeePage {
    public static void showEmployeeInterface(Stage primaryStage) {
        primaryStage.setTitle("Interface Administrateur");

        BorderPane mainLayout = new BorderPane();

        HBox employeeLayout = new HBox(10);
        employeeLayout.setAlignment(Pos.CENTER);

        Button clientsButton = createGalleryButton("client.jpg", "               Clients");
        clientsButton.setOnAction(e -> ClientsPage.showClientsInterface(primaryStage));

        Button reservationsButton = createGalleryButton("reservation.png", "           Reservations");
        reservationsButton.setOnAction(e -> ReservationsPage.showReservationsInterface(primaryStage));

        Button employeesButton = createGalleryButton("employés.png", "              Employés");
        employeesButton.setOnAction(e -> EmployeesPage.showEmployeesInterface(primaryStage));

        Button chambresButton = createGalleryButton("CHAMBRES.png", "             Chambres");
        chambresButton.setOnAction(e -> ChambresPage.showChambresInterface(primaryStage));

        employeeLayout.getChildren().addAll(backtologin.createBackButton(primaryStage),clientsButton, reservationsButton, employeesButton, chambresButton);
        mainLayout.setCenter(employeeLayout);

        Scene employeeScene = new Scene(mainLayout, 800, 400);
        employeeScene.getStylesheets().add("style.css");

        primaryStage.setScene(employeeScene);
       // primaryStage.setMaximized(true); // Mettre en plein écran
        primaryStage.show();
    }

    private static Button createGalleryButton(String imageName, String description) {
        Button button = new Button();
        button.getStyleClass().add("gallery-button");

        Image image = new Image("file:C:\\Users\\nouta\\eclipse-workspace\\Application\\imagesss/" + imageName);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(150); // Ajustez la largeur selon vos besoins
        imageView.setFitHeight(150); // Ajustez la hauteur selon vos besoins

        Label descriptionLabel = new Label(description);
        descriptionLabel.getStyleClass().add("description-label");

        VBox buttonContent = new VBox(5);
        buttonContent.getChildren().addAll(imageView, descriptionLabel);
        button.setGraphic(buttonContent);

        return button;
    }
}
