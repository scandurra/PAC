package text;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * The Class AreaTestoFrame_a1.
 * 
 * Digito in una area di testo.
 * I caratteri di cio' che digito vengono contati e 
 * visualizzati in un altro pannello.
 * Implemento DocumentListener per "ascoltare" le azioni sul JTextArea.
 */
public class AreaTestoFrame_a1 extends JFrame implements DocumentListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The testo. */
	private JTextArea testo;

	/** The caratteri. */
	private JLabel caratteri;

	/**
	 * Instantiates a new area testo frame a 1.
	 */
	public AreaTestoFrame_a1() {
		// Imposto il JFrame e creo il container
		setTitle("Demo casella di testo");
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
		caratteri = new JLabel();
		caratteri.setText("-");
		// ... e lo aggiungo
		contentPane.add(caratteri, BorderLayout.SOUTH);
	}

	/**
	 * Insert update.
	 *
	 * Evento inserisci carattere.
	 * @param e the e
	 */
	public void insertUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("Ci sono " + lunghezza + " caratteri");
	}

	/**
	 * Removes the update.
	 *
	 * Evento rimuovi carattere.
	 * @param e the e
	 */
	public void removeUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("Ci sono " + lunghezza + " caratteri");
	}

	/**
	 * Changed update.
	 *
	 * Evento cambia carattere.
	 * @param e the e
	 */
	public void changedUpdate(DocumentEvent e) {
		int lunghezza = testo.getText().length();
		caratteri.setText("Ci sono " + lunghezza + " caratteri");
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new AreaTestoFrame_a1();
		frame.setVisible(true);
	}
}
