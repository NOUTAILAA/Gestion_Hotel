import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvExporter {

    public static void exportToCsv(List<EmployeesPage.TeamSchedule> teamSchedules, String filePath) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath));) {
            // Écrire l'en-tête du fichier CSV
            String[] header = {"Jour", "Equipe 1", "Equipe 2", "Equipe 3", "Equipe 4", "Equipe 5"};
            writer.writeNext(header);

            // Écrire les données dans le fichier CSV
            for (EmployeesPage.TeamSchedule teamSchedule : teamSchedules) {
                String[] data = {
                        teamSchedule.getDay(),
                        convertBooleanToString(teamSchedule.getTeam("team1").get()),
                        convertBooleanToString(teamSchedule.getTeam("team2").get()),
                        convertBooleanToString(teamSchedule.getTeam("team3").get()),
                        convertBooleanToString(teamSchedule.getTeam("team4").get()),
                        convertBooleanToString(teamSchedule.getTeam("team5").get())
                };
                writer.writeNext(data);
            }

            System.out.println("Exportation vers CSV réussie.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String convertBooleanToString(boolean value) {
        return value ? "1" : "0";
    }
}
