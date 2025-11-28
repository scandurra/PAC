package sonarlint;

import java.util.ArrayList;
import java.util.List;

/**
 * Errori:
	duplicazione
	missing null-check
	metodo statico che richiama quello di Main ⇒ dipendenza circolare
	uso improprio di eccezioni
	variabili inutili
 */
public class DataProcessor {

    private List<String> results = new ArrayList<>();

    public void process(String level) {

        // duplicazione e ciclomatica
        if (level.equals("low")) {
            results.add("L1");
        }
        if (level.equals("medium")) {
            results.add("M1");
        }
        if (level.equals("high")) {
            results.add("H1");
        }
        if (level.equals("critical")) {
            results.add("C1");
        }

        // Ridondante
        if (!level.equals("unknown")) {
            results.add("OK");
        }

        // dipendenza ciclica
        if (level.equals("unknown")) {
            Main.main(null);
        }
    }

    public List<String> getResults() {
        return results;
    }
}