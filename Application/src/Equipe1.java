import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Equipe1 extends JFrame {

    private JTable table;

    public Equipe1() {
        super("Table Employe Viewer");

        try {
            // Établir la connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/bdbd3";
            String utilisateur = "root";
            String motDePasse = "1234";

            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Créer la requête SQL pour récupérer toutes les lignes de la table employe
            String requeteSQL = "SELECT cin, nom, prenom,num_equipe, poste, telephone FROM employe where num_equipe = 1";

            // Créer l'instruction SQL
            Statement statement = connexion.createStatement();

            // Exécuter la requête et récupérer le résultat dans une liste
            List<String[]> data = fetchData(statement.executeQuery(requeteSQL));

            // Créer un modèle de table avec les données
            ResultSetTableModel model = new ResultSetTableModel(data);

            // Créer la table avec le modèle
            table = new JTable(model);

            // Ajouter la table à un JScrollPane pour permettre le défilement
            JScrollPane scrollPane = new JScrollPane(table);

            // Ajouter le JScrollPane à la fenêtre
            add(scrollPane, BorderLayout.CENTER);

            // Fermer les ressources
            statement.close();
            connexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Configurer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private List<String[]> fetchData(ResultSet resultSet) throws SQLException {
        List<String[]> data = new ArrayList<>();
        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next()) {
            String[] row = new String[metaData.getColumnCount()];
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                row[i - 1] = resultSet.getString(i);
            }
            data.add(row);
        }

        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Equipe1());
    }

    // Modèle de table basé sur une liste de données
    private static class ResultSetTableModel extends AbstractTableModel {

        private List<String[]> data;
        private String[] columnNames;

        public ResultSetTableModel(List<String[]> data) {
            this.data = data;
            this.columnNames = getColumnNames(data);
        }

        private String[] getColumnNames(List<String[]> data) {
            if (!data.isEmpty()) {
                return new String[]{ "cin", "nom", "prenom", "Num_equipe", "poste", "telephone"};
            }
            return new String[0];
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data.get(rowIndex)[columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
