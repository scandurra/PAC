package text;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

//Digito in una area di testo.
//I caratteri di cio' che digito vengono contati e visualizzati in 
//un altro pannello.
//In questa versione l'area del testo e' inserita dentro un pannello
//di scorrimento
public class AreaTestoFrame_b1 extends JFrame implements DocumentListener {
	private JTextArea testo;
	private JTextField caratteri;

	public AreaTestoFrame_b1() {
		// Imposto il JFrame
		setTitle("demo casella di testo");
		setSize(300, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		// Creo la JTextAea
		testo = new JTextArea();
		// imposto il line wrapping
		testo.setLineWrap(true);
		testo.setWrapStyleWord(true);
		// aggiungo il listener
		testo.getDocument().addDocumentListener(this);

		// Creo il pannello con lo scroll e ci aggiungo la JTextArea
		JScrollPane scroll = new JScrollPane(testo);
		// Aggiungo il pannello al container
		contentPane.add(scroll, BorderLayout.CENTER);

		// Pannello di output
		caratteri = new JTextField();
		contentPane.add(caratteri, BorderLayout.SOUTH);
	}

	// EVENTI
	public void insertUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("ci sono " + lunghezza + " caratteri");
	}

	public void removeUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("ci sono " + lunghezza + " caratteri");
	}

	public void changedUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("ci sono " + lunghezza + " caratteri");
	}

	public static void main(String[] args) {
		JFrame frame = new AreaTestoFrame_b1();
		frame.setVisible(true);
	}
}
