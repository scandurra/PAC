package approfondimento;

import javax.swing.*;
import java.awt.*;

//Filtri e visualizzatori TXT
import fileChooser.*;

/*
Questo esempio combina caricamento e salvataggio
tramite JFileChooser
*/
public class OpenSaveApp {
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

		JFrame f = new JFrame();
		JTextArea area = new JTextArea();
		JButton apri = new JButton("Apri");
		JButton salva = new JButton("Salva");
		JPanel panel = new JPanel();
		panel.add(apri);
		panel.add(salva);
		f.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		apri.addActionListener(new OpenListener(area, fileChooser)); // La classe OpenListener e' definita in un'altro
																		// file
		salva.addActionListener(new SaveListener(area, fileChooser)); // La classe SaveListener e' definita in un'altro
																		// file
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
