package text;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra l'utilizzo dell'ActionListener 
//nelle caselle di testo: visualizza in chiaro una
//password in una casella di testo
//Catturo l'invio di una stringa con un ActionListener che pu� catturare solo questa azione
//da un textField, se volessi catturare altro dovrei implementare un DocumentListener
public class CampoTestoFrame_a1 extends JFrame implements ActionListener {
	private JPasswordField password;
	private JTextField testo;

	public CampoTestoFrame_a1() {
		// Imposto il JFrame
		setTitle("demo casella di testo");
		setSize(300, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Container
		Container contentPane = getContentPane();

		// Creo un JPasswordField
		password = new JPasswordField(18);
		password.addActionListener(this);
		// E lo aggiungo "a nord"
		contentPane.add(password, BorderLayout.NORTH);

		// Creo un JTextField e lo aggiungo "a sud"
		testo = new JTextField();
		contentPane.add(testo, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		// Catturo l'azione di invio stringa
		String s = new String(password.getPassword());
		// setto il testo nel text field.
		testo.setText(s);
	}

	public static void main(String[] args) {
		JFrame frame = new CampoTestoFrame_a1();
		frame.setVisible(true);
	}
}
