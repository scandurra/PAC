package fileChooserAndSaver;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * The listener interface for receiving save events. The class that is
 * interested in processing a save event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addSaveListener</code> method. When the save event occurs,
 * that object's appropriate method is invoked.
 *
 * Il listener per il salvataggio di un file di testo.
 */
public class SaveListener implements ActionListener {

	/** The area. */
	private JTextArea area;

	/** The file chooser. */
	private JFileChooser fileChooser;

	/**
	 * Instantiates a new save listener.
	 *
	 * @param a  the a
	 * @param fc the fc
	 */
	public SaveListener(JTextArea a, JFileChooser fc) {
		area = a;
		fileChooser = fc;

		// Imposto la directory corrente
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	public void actionPerformed(ActionEvent e) {
		// Imposto il titolo della finestra
		fileChooser.setDialogTitle("Salva file");
		// Recupero il testo da salvare
		String text = area.getText();

		int risposta2 = JOptionPane.NO_OPTION;
		File f = null;
		String ext = null;
		while (risposta2 == JOptionPane.NO_OPTION) { // Finche' non decido di salvare o di rinunciare
			// Visualizzo la finestra di dialogo
			int risposta = fileChooser.showSaveDialog(area);
			if (risposta == JFileChooser.APPROVE_OPTION) { // Se ho premuto il tasto salva
				try {
					// Recupero il file selezionato
					f = fileChooser.getSelectedFile();
					// Recupero l'estensione del file
					ext = fileChooser.getFileFilter().toString();
					// Recupero il path del file
					String str = f.getCanonicalPath();
					// Se il nome del file non contiene l'estensione, la aggiungo io a mano
					if (!str.toLowerCase().endsWith("." + ext))
						f = new File(str + "." + ext);
					// Se il file esiste chiedo se lo voglio sovrascrivere
					if (f.exists())
						risposta2 = JOptionPane.showConfirmDialog(area, "Il file esiste gia',\nlo vuoi sovrascrivere?",
								"Sovrascrittura", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
					else
						risposta2 = JOptionPane.YES_OPTION;
				} catch (Exception ex) {
				}
			} else
				risposta2 = JOptionPane.CANCEL_OPTION;
		}
		if (risposta2 == JOptionPane.YES_OPTION) {
			try (BufferedWriter writer2 = new BufferedWriter(new FileWriter(f))) {
				writer2.write(text);
			} catch (Exception ex) {
			}
		}
	}
}
