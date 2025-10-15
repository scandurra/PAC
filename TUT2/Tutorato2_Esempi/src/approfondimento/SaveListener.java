package approfondimento;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;

//Il listener per il salvataggio di un file di testo
public class SaveListener implements ActionListener {
	private JTextArea area;
	private JFileChooser fileChooser;

	public SaveListener(JTextArea a, JFileChooser fc) {
		area = a;
		fileChooser = fc;

		// Imposto la directory corrente
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
	}

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
			if (risposta == fileChooser.APPROVE_OPTION) { // Se ho premuto il tasto salva
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
			try {
				// Apro il file
				BufferedWriter writer = new BufferedWriter(new FileWriter(f));

				// Salvo il file
				writer.write(text);
			} catch (Exception ex) {
			}
		}
	}
}
