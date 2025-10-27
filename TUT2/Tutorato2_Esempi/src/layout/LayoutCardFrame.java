package layout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Class LayoutCardFrame.
 * 
 * Questo esempio mostra un CardLayout all'opera
 * implemento ActionListener perchè voglio usare un bottone per 
 * cambiare da una card all'altra
 */
public class LayoutCardFrame extends JFrame implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The panel color. */
	// Creo i Panel e il layout
	private JPanel panelColor = new JPanel();

	/** The panel button. */
	private JPanel panelButton = new JPanel();

	/** The card. */
	private CardLayout card = new CardLayout();

	/**
	 * Instantiates a new layout card frame.
	 */
	// Costruttore
	public LayoutCardFrame() {
		// Imposto titolo, dimensioni e posizione
		setTitle("CardLayout all'opera");
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Mi faccio restituire il container di questo frame e aggiungo i due JPanel
		// Uno per i bottoni e uno che ospiter� il panel colorato
		Container contentPane = getContentPane();
		contentPane.add(panelColor, BorderLayout.CENTER);
		contentPane.add(panelButton, BorderLayout.NORTH);
		panelColor.setLayout(card);

		for (int i = 0; i < 3; i++) {
			// Creo un panel per colorarlo
			JPanel p = new JPanel();
			// imposto un colore
			p.setBackground(new Color(35 * i % 256, 175 * i % 256, 130 * i % 256));
			// aggiungo il panel appena colorato al panel che lo deve ospitare dandogli un
			// nome (il numero in formato stringa)
			// ATTENZIONE: Non imposto direttamente il colore del panelColor perch� voglio
			// mostrare
			// la funzionalit� del metodo show del CardLayout.
			panelColor.add(p, "" + i);

			// Creo e aggiungo un bottone
			JButton b = new JButton("" + i);
			panelButton.add(b);
			// imposto il listener
			b.addActionListener(this);
		}
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	// Action listener condiviso da tutti i bottoni
	public void actionPerformed(ActionEvent e) {
		// Ottengo il bottone sorgente dell'evento
		JButton b = (JButton) e.getSource();
		// ottengo la stringa
		String str = b.getText();
		// Visualizzo il panel corrispondente tra quelli associati a panelColor
		// richiamandolo con la stringa
		card.show(panelColor, str);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new LayoutCardFrame();
		frame.setVisible(true);
	}
}
