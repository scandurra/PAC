package colorChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ColorChooserFrame.
 * Questo esempio mostra il classico modo di utilizzo del JColorChooser
 */
public class ColorChooserFrame extends JFrame implements ActionListener {

	/** The label. */
	// Label che mostra il colore
	private JLabel label = new JLabel();

	/**
	 * Instantiates a new color chooser frame.
	 */
	public ColorChooserFrame() {
		// Imposto il frame
		setTitle("Colore app");
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

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	public void actionPerformed(ActionEvent e) {
		// Visualizzo la finestra di selezione del colore
		Color c = JColorChooser.showDialog(this, "Selezionare un colore", label.getBackground());
		if (c != null)
			label.setBackground(c);
	}

	/**
	 * The main method.
	 *
	 * @param a the arguments
	 */
	public static void main(String[] a) {
		ColorChooserFrame f = new ColorChooserFrame();
		f.setVisible(true);
		f.setSize(249, 91);
	}
}