package colorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Questo esempio mostra il classico modo di utilizzo del JColorChooser
public class ColorChooserFrame extends JFrame implements ActionListener {

	// Label che mostra il colore
	private JLabel label = new JLabel();

	public ColorChooserFrame() {
		// Imposto il frame
		setTitle("Colore in azione");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto l'etichetta
		label.setBackground(Color.black);
		label.setOpaque(true);
		// Bottone
		JButton colore = new JButton("Colore");
		// Pannello
		JPanel panel = new JPanel();
		// Aggungo il bottone al pannello
		panel.add(colore);
		colore.setText("Colour");

		Container container = getContentPane();
		// Aggiungo la label al container
		container.add(label, BorderLayout.CENTER);
		// Aggiungo il pannello al container
		container.add(panel, BorderLayout.SOUTH);
		// Listener per il bottone colore
		colore.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// Visualizzo la finestra di selezione del colore
		Color c = JColorChooser.showDialog(this, "Selezionare un colore", label.getBackground());
		if (c != null)
			label.setBackground(c);
	}

	public static void main(String[] a) {
		ColorChooserFrame f = new ColorChooserFrame();
		f.setVisible(true);
		f.setSize(249, 91);
	}
}