package fileChooser;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

//Il listener per il caricamento di un file di testo
public class OpenListener implements ActionListener {
	private JTextArea area;
	private JFileChooser fileChooser;

	public OpenListener(JTextArea a, JFileChooser fc) {
		area = a;
		fileChooser = fc;
		// Imposto la directory corrente
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	}

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
