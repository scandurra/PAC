package fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * The Class FileChooserApp_a1. Questo esempio mostra tutte le caratteristiche
 * del JFileChooser + e dimostra il suo funzionamento aprendo un file di testo
 */
public class FileChooserApp_a1 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// Imposto il frame
		JFrame f = new JFrame();
		JTextArea area = new JTextArea();
		// Bottone apri
		JButton apri = new JButton("Apri");
		// Pannello
		JPanel panel = new JPanel();
		panel.add(apri);
		// aggiungo scroll text area
		f.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);
		// Aggiungo il panel precedentemente creato
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		// Listener custom per il bottone, gli passo l'area di testo e il JFileChooser
		apri.addActionListener(new OpenListener(area, new JFileChooser())); // La classe OpenListener e' definita in
																			// un'altro file
		// Setto le dimensioni
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
