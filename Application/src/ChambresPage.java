import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChambresPage {
    private static final String[] IMAGE_NAMES = {
            "chambre-classique.jpg",
            "deluxe.jpg",
            "chambre-superieur.jpg",
            "suite-duplex.jpg"
    };

    private static int currentImageIndex = 0;

    public static void showChambresInterface(Stage primaryStage) {
        primaryStage.setTitle("Gestion des Chambres");

        VBox chambresLayout = new VBox(10);

        // Image gallery
        ImageView imageView = new ImageView();
        imageView.setFitWidth(700);
        imageView.setFitHeight(325);
        updateImage(imageView);

        HBox galleryControls = new HBox(10);
        Button prevButton = new Button("Precedent");
        Button nextButton = new Button("Suivant");

        prevButton.setOnAction(e -> {
            currentImageIndex = (currentImageIndex - 1 + IMAGE_NAMES.length) % IMAGE_NAMES.length;
            updateImage(imageView);
        });

        nextButton.setOnAction(e -> {
            currentImageIndex = (currentImageIndex + 1) % IMAGE_NAMES.length;
            updateImage(imageView);
        });
        chambresLayout.getChildren().add(Utils.createBackButton(primaryStage));
        galleryControls.getChildren().addAll(prevButton, nextButton);
        galleryControls.setAlignment(Pos.CENTER);

        chambresLayout.getChildren().addAll(imageView, galleryControls);

        // Add the rest of your logic here for managing chambres

        Button backButton = new Button("<<");
        backButton.setOnAction(e -> EmployeePage.showEmployeeInterface(primaryStage));

        Scene chambresScene = new Scene(chambresLayout, 600, 400);
        primaryStage.setScene(chambresScene);
        primaryStage.show();
    }

    private static void updateImage(ImageView imageView) {
        String imagePath = "file:C:\\Users\\nouta\\eclipse-workspace\\Application\\imagesss\\" + IMAGE_NAMES[currentImageIndex];
        //System.out.println("Image Path: " + imagePath);  // Print for debugging
        Image image = new Image(imagePath);
        imageView.setImage(image);
    }
}
