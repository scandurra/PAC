package fileChooser;

import javax.swing.filechooser.FileView;
import java.io.*;
import javax.swing.*;

//Classe per la gestione delle icone da visualizzare in un JFileChooser
public class TXTView extends FileView {
	private ImageIcon icona;

	public TXTView() {
		icona = new ImageIcon("icona.gif");
	}

	// Filtra e mette l'icona
	public Icon getIcon(File f) {
		String str = f.getName().toLowerCase();
		if (str.endsWith(".txt")) {
			return icona;
		} else {
			return null;
		}
	}

	public String getDescription(File f) {
		return null;
	}

	public String getName(File f) {
		return null;
	}

	public String getTypeDescription(File f) {
		return null;
	}

	public Boolean isTraversable(File f) {
		return null;
	}
}
