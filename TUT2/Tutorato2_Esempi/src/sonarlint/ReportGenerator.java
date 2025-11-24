package sonarlint;

import java.util.List;

/*
 * 
metodo troppo lungo
concatenazione inefficiente
duplicazione
controllo nullo mancante
dipendenza verso FileUtils ⇒ ciclo
 */
public class ReportGenerator {

    public String generate(List<String> data) {

        String report = "";

        for (String d : data) {
            report += d + ";"; // inefficiente
        }

        // duplicazione intenzionale
        for (String d : data) {
            if (d.contains("1")) {
                report += "[WARNING]" + d;
            }
        }

        // Nessun controllo di errore
        FileUtils.write("report.txt", report);

        return report;
    }
}
