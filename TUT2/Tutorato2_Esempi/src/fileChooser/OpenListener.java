package fileChooser;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * The listener interface for receiving open events. The class that is
 * interested in processing a open event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addOpenListener</code> method. When the open event occurs,
 * that object's appropriate method is invoked.
 * 
 * Il listener per il caricamento di un file di testo
 *
 * @see OpenEvent
 */
public class OpenListener implements ActionListener {

	/** The area. */
	private JTextArea area;

	/** The file chooser. */
	private JFileChooser fileChooser;

	/**
	 * Instantiates a new open listener.
	 *
	 * @param a  the a
	 * @param fc the fc
	 */
	public OpenListener(JTextArea a, JFileChooser fc) {
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
		fileChooser.setDialogTitle("Apri file");
		// Visualizzo la finestra di dialogo
		int risposta = fileChooser.showOpenDialog(area);

		if (risposta == fileChooser.APPROVE_OPTION) {// Se ho premuto il tasto apri

			// Recupero il file selezionato
			File f = fileChooser.getSelectedFile();
			try {
				// Apro il file creando un reader di stringhe
				BufferedReader reader = new BufferedReader(new FileReader(f));

				// Carico il file fino alla fine e lo aggiungo alla text area
				String str = null;
				while ((str = reader.readLine()) != null)
					area.append(str + "\n");
			} catch (Exception ex) {
			}
		}
	}
}
