package fileChooser;

import javax.swing.filechooser.FileView;
import java.io.*;
import javax.swing.*;

/**
 * The Class TXTView.
 * Classe per la gestione delle icone da visualizzare in un JFileChooser.
 */
public class TXTView extends FileView {
	
	/** The icona. */
	private ImageIcon icona;

	/**
	 * Instantiates a new TXT view.
	 */
	public TXTView() {
		icona = new ImageIcon("icona.gif");
	}

	/**
	 * Gets the icon.
	 * 
	 * Filtra e mette l'icona
	 *
	 * @param f the f
	 * @return the icon
	 */
	public Icon getIcon(File f) {
		String str = f.getName().toLowerCase();
		if (str.endsWith(".txt")) {
			return icona;
		} else {
			return null;
		}
	}

	/**
	 * Gets the description.
	 *
	 * @param f the f
	 * @return the description
	 */
	public String getDescription(File f) {
		return null;
	}

	/**
	 * Gets the name.
	 *
	 * @param f the f
	 * @return the name
	 */
	public String getName(File f) {
		return null;
	}

	/**
	 * Gets the type description.
	 *
	 * @param f the f
	 * @return the type description
	 */
	public String getTypeDescription(File f) {
		return null;
	}

	/**
	 * Checks if is traversable.
	 *
	 * @param f the f
	 * @return the boolean
	 */
	public Boolean isTraversable(File f) {
		return null;
	}
}
