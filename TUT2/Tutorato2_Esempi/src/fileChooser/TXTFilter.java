package fileChooser;

import javax.swing.filechooser.FileFilter;
import java.io.*;

/**
 * The Class TXTFilter.
 * 
 * Filtro per i file txt TXT
 */
public class TXTFilter extends FileFilter {

	/**
	 * Accept.
	 *
	 * @param f the f
	 * @return true, if successful
	 */
	public boolean accept(File f) {
		// Definisco il filtro:
		// tutti i file il cui nome, in minuscolo, finisce con ".txt" oppure sono
		// cartelle
		return f.getName().toLowerCase().endsWith(".txt") || f.isDirectory();
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return "File TXT";
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "txt";
	}
}
