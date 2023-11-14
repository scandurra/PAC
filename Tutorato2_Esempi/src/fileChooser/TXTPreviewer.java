package fileChooser;

import java.io.*;
import java.beans.*;
import javax.swing.*;
import java.awt.*;

//Implemento PropertyChangeListener che mi consente di catturare gli eventi di cambio di propriet�
//come selected/not selected
//Estendo JTextArea perch� implemento la preview come area testo
public class TXTPreviewer extends JTextArea implements PropertyChangeListener {
	public TXTPreviewer(JFileChooser fc) {
		// Rendo la casella di testo non editabile
		this.setEditable(false);
		// Imposto un testo di default
		this.setText("Nome =\nDimensione =");
		// Aggiungo un bordo
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		// Imposto la casella di testo come listener degli eventi di cambiamento di
		// proprieta'
		// del JFileChooser
		fc.addPropertyChangeListener(this);
	}

	public void propertyChange(PropertyChangeEvent e) {
		// Recupero il nome della proprieta' che e' variata nel JFileChooser
		String prop = e.getPropertyName();
		if (prop == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) { // Se e' variata la proprieta' "File Selezionato"

			// Ottengo il file selezionato
			File file = (File) e.getNewValue();

			System.out.println(file);

			if (file != null) {
				// Recupero le informazioni
				StringBuffer buffer = new StringBuffer();
				buffer.append("Nome = " + file.getName() + "\n");
				buffer.append("Dimensione = " + file.length() + " byte");

				// Visualizzo le informazioni sul JTextArea
				this.setText(buffer.toString());
			} else
				this.setText("Nome =\nDimensione =");
		}
	}
}
