package text;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

//Digito in una area di testo.
//I caratteri di cio' che digito vengono contati e 
//visualizzati in un altro pannello
//Implemento DocumentListener per "ascoltare" le azioni sul JTextArea
public class AreaTestoFrame_a1 extends JFrame implements DocumentListener {
	private JTextArea testo;
	private JTextField caratteri;

	public AreaTestoFrame_a1() {
		// Imposto il JFrame e creo il container
		setTitle("demo casella di testo");
		setSize(300, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		// Creo un'area di testo
		testo = new JTextArea();
		// imposto il line wrapping
		testo.setLineWrap(true);
		testo.setWrapStyleWord(true);
		// aggiungo il document listener che � implementato in questa classe
		testo.getDocument().addDocumentListener(this);
		// aggiungo la text area
		contentPane.add(testo, BorderLayout.CENTER);

		// Creo un text field...
		caratteri = new JTextField();
		// ... e lo aggiungo
		contentPane.add(caratteri, BorderLayout.SOUTH);
	}

	// Evento insrisci carattere
	public void insertUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("ci sono " + lunghezza + " caratteri");
	}

	// Evento rimuovi carattere
	public void removeUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("ci sono " + lunghezza + " caratteri");
	}

	// Evento cambia carattere
	public void changedUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("ci sono " + lunghezza + " caratteri");
	}

	public static void main(String[] args) {
		JFrame frame = new AreaTestoFrame_a1();
		frame.setVisible(true);
	}
}
