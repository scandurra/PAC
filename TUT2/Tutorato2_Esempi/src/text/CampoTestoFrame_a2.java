package text;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * The Class CampoTestoFrame_a2.
 * 
 * Questo esempio mostra l'utilizzo del DocumentListener 
 * nelle caselle di testo.
 * Implemento il DocumentListener per catturare tutti gli eventi.
 */
public class CampoTestoFrame_a2 extends JFrame implements DocumentListener {

	/** The password. */
	private JPasswordField password;

	/** The testo. */
	private JTextField testo;

	/**
	 * Instantiates a new campo testo frame a 2.
	 */
	public CampoTestoFrame_a2() {
		// Imposto il JFrame
		setTitle("Demo casella di testo");
		setSize(300, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// il container
		Container contentPane = getContentPane();

		// Creo e aggiungo il JPasswordField
		password = new JPasswordField(18);
		// Il frame fa da DocumentListener
		password.getDocument().addDocumentListener(this);
		contentPane.add(password, BorderLayout.NORTH);

		// Creo e aggiungo il JTextField
		testo = new JTextField();
		contentPane.add(testo, BorderLayout.SOUTH);
	}

	// Metodi dell'interface DocumentListener
	/**
	 * Insert update.
	 *
	 * @param e the e
	 */
	// Catturo tutti gli eventi ed ogni volta mostro il testo "in chiaro".
	public void insertUpdate(DocumentEvent e) {
		String s = new String(password.getPassword());
		testo.setText(s);
	}

	/**
	 * Removes the update.
	 *
	 * @param e the e
	 */
	public void removeUpdate(DocumentEvent e) {
		String s = new String(password.getPassword());
		testo.setText(s);
	}

	/**
	 * Changed update.
	 *
	 * @param e the e
	 */
	public void changedUpdate(DocumentEvent e) {
		String s = new String(password.getPassword());
		testo.setText(s);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new CampoTestoFrame_a2();
		frame.setVisible(true);
	}
}
