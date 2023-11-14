package text;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

//Questo esempio mostra l'utilizzo del DocumentListener 
//nelle caselle di testo
//Implemento il DocumentListener per catturare tutti gli eventi
public class CampoTestoFrame_a2 extends JFrame implements DocumentListener {
	private JPasswordField password;
	private JTextField testo;

	public CampoTestoFrame_a2() {
		// Imposto il JFrame
		setTitle("demo casella di testo");
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
	// Catturo tutti gli eventi ed ogni volta mostro il testo "in chiaro".
	public void insertUpdate(DocumentEvent e) {
		String s = new String(password.getPassword());
		testo.setText(s);
	}

	public void removeUpdate(DocumentEvent e) {
		String s = new String(password.getPassword());
		testo.setText(s);
	}

	public void changedUpdate(DocumentEvent e) {
		String s = new String(password.getPassword());
		testo.setText(s);
	}

	public static void main(String[] args) {
		JFrame frame = new CampoTestoFrame_a2();
		frame.setVisible(true);
	}
}
