package fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * The Class AccessoryApp. Questo esempio aggiunge degli "accessori" al
 * JFileChooser
 */
public class AccessoryApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Creo il JFileChooser
		JFileChooser fileChooser = new JFileChooser();
		// Disabilito al visualizzazione di tutti i tipi di file
		fileChooser.setAcceptAllFileFilterUsed(false);
		// Abilito la visualizzazione dei file di tipo TXT
		fileChooser.setFileFilter(new TXTFilter()); // La classe TXTFilter e' definita in un'altro file
		// Imposto il tipo di icona per i file TXT
		fileChooser.setFileView(new TXTView()); // La classe TXTView e' definita in un'altro file
		// Imposto l'accessory del filechooser
		fileChooser.setAccessory(new TXTPreviewer(fileChooser)); // La classe TXTPreviewer e' definita in un'altro file

		// Preparo il Frame
		JFrame f = new JFrame();
		// Preparo la text area
		JTextArea area = new JTextArea();
		// Preparo il bottone
		JButton apri = new JButton("Apri");
		// Creo un pannello
		JPanel panel = new JPanel();
		// Aggiungo il bottone al pannello
		panel.add(apri);
		// Aggiungo la text area ad uno scroll pane che aggiungo al centro del frame
		f.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);
		// Aggiungo il panel al frame
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		// Action Listener custom per il bottone
		apri.addActionListener(new OpenListener(area, fileChooser)); // La classe OpenListener e' definita in un'altro
																		// file
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
