package fileChooser;

import javax.swing.*;
import java.awt.*;

/*
Questo esempio abilita la visualizzazione solo di alcuni
tipi di file nel JFileChooser
*/
public class FileChooserApp_b1 {
	public static void main(String[] args) {
		// Creo il JFileChooser
		JFileChooser fileChooser = new JFileChooser();
		// Disabilito al visualizzazione di tutti i tipi di file
		fileChooser.setAcceptAllFileFilterUsed(false);
		// Abilito la visualizzazione dei file di tipo TXT
		fileChooser.setFileFilter(new TXTFilter()); // La classe TXTFilter e' definita in un'altro file

		// Imposto il JFrame
		JFrame f = new JFrame();
		// TextArea
		JTextArea area = new JTextArea();
		// Bottone
		JButton apri = new JButton("Apri");
		// Panel
		JPanel panel = new JPanel();
		// Aggiungo bottone al panel
		panel.add(apri);
		// Scroll al centro
		f.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);
		// Aggiungo il panel
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		// Associo l'action listener custom al bottone
		apri.addActionListener(new OpenListener(area, fileChooser)); // La classe OpenListener e' definita in un'altro
																		// file
		// Setto le dimensioni
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
