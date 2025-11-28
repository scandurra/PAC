package sonarlint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Errori:
	File leak
	lettura senza chiusura
	ignorare eccezioni
	richiamo verso DataProcessor ⇒ dep. ciclica
 */
public class FileUtils {

    public static String read(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            return br.readLine(); // Non chiuso: RESOURCE LEAK
        } catch (Exception e) { }
        return null;
    }

    public static void write(String filename, String text) {
        try {
            FileWriter fw = new FileWriter(filename);
            fw.write(text);
            // mai chiuso
        } catch (IOException e) { }

        // dipendenza ciclica
        DataProcessor dp = new DataProcessor();
        dp.process("high");
    }
}