package fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * The Class FileChooserApp_b2. Questo esempio abilita la visualizzazione
 * "visiva" dei tipi di file accettati nel JFileChooser
 */
public class FileChooserApp_b2 {

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

		// Preparo il Frame
		JFrame f = new JFrame();
		// Text Area
		JTextArea area = new JTextArea();
		// Button
		JButton apri = new JButton("Apri");
		// Panel
		JPanel panel = new JPanel();
		// Aggiungo il button al panel
		panel.add(apri);
		// Aggiungo l'area alla JScrollPane e quest'ultima al contenuto del frame al
		// centro
		f.getContentPane().add(new JScrollPane(area), BorderLayout.CENTER);
		// Aggiungo il panel al frame
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		// Imposto il listener custom
		apri.addActionListener(new OpenListener(area, fileChooser)); // La classe OpenListener e' definita in un'altro
																		// file
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
