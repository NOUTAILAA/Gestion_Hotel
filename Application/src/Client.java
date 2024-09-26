import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty cin;
    private final SimpleStringProperty nom;
    private final SimpleStringProperty prenom;
    private final SimpleStringProperty email;
    private final SimpleStringProperty telephone;

    public Client(int id, String cin, String nom, String prenom, String email, String telephone) {
        this.id = new SimpleIntegerProperty(id);
        this.cin = new SimpleStringProperty(cin);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.telephone = new SimpleStringProperty(telephone);
    }

    // Getter methods

    public int getId() {
        return id.get();
    }

    public String getCin() {
        return cin.get();
    }

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getTelephone() {
        return telephone.get();
    }

    // Property methods

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public SimpleStringProperty cinProperty() {
        return cin;
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public SimpleStringProperty telephoneProperty() {
        return telephone;
    }
}
