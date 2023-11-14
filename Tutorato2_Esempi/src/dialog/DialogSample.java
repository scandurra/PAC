package dialog;

import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra come utilizzare le finestre di dialogo
//Implemento l'ActionListener per catturare l'evento dei bottonis
public class DialogSample extends JFrame implements ActionListener {
	private JButton b1 = new JButton("Modale");
	private JButton b2 = new JButton("Non Modale");

	public DialogSample() {
		// Preaparo il JFrame
		setTitle("Usare le JDialog");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Preparo un panel
		JPanel p = new JPanel();
		// Aggiungo i bottoni
		p.add(b1);
		p.add(b2);
		// Aggiungo il panel al container
		getContentPane().add(p);

		// Imposto gli ActionListener (la classe corrente)
		b1.addActionListener(this);
		b2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Creo un dialog...
		JDialog d = new JDialog(this);
		// ...con una certa size
		d.setSize(300, 300);

		// Catturo la sorgente dell'evento
		Object source = e.getSource();
		if (source == b1) {
			d.setTitle("Io sono Modale!!!");
			d.setModal(true); // Set modal
		} else if (source == b2) {
			d.setTitle("Io sono Non Modale!!!");
			d.setModal(false); // Set modal
		}

		d.setVisible(true);
	}

	public static void main(String[] args) {
		DialogSample dialogsample = new DialogSample();
		dialogsample.setVisible(true);
	}
}