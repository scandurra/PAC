package fileChooser;

import javax.swing.filechooser.FileFilter;
import java.io.*;

// Filtro per i file txt TXT
//
public class TXTFilter extends FileFilter {
	public boolean accept(File f) {
		// Definisco il filtro:
		// tutti i file il cui nome, in minuscolo, finisce con ".txt" oppure sono
		// cartelle
		return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
	}

	public String getDescription() {
		return "File TXT";
	}

	public String toString() {
		return "txt";
	}
}
