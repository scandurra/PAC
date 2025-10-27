package layout;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * The Class LayoutFlowFrame_a1.
 * 
 * Questo esempio mostra un FlowLayout all'opera.
 * Ogni volta che sulla tastiera premo il carattere 
 * 'b' si aggiunge un nuovo bottone
 * Implemento KeyListener per "ascoltare" i pulsanti premuti da tastiera
 */
public class LayoutFlowFrame_a1 extends JFrame implements KeyListener {

	/** The pannello bottoni. */
	// Creo il JPanel che conterrà i bottoni
	private JPanel pannelloBottoni;

	/** The contatore bottoni. */
	private int contatoreBottoni = 0;

	/**
	 * Instantiates a new layout flow frame a 1.
	 */
	// Costruttore
	public LayoutFlowFrame_a1() {
		// imposto titolo, misure e posizione
		setTitle("FlowLayout all'opera (premi b)");
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Il frame stesso implementa il listener
		addKeyListener(this);
		// Creo un container per il panel
		Container contentPane = getContentPane();
		// inizializzo il panel...
		pannelloBottoni = new JPanel();
		// ... imposto il layout....
		pannelloBottoni.setLayout(new FlowLayout());
		// COSA SUCCEDEREBBE SE IL LAYOUT FOSSE DIVERSO?
		// pannelloBottoni.setLayout(new BorderLayout());
		// ...e lo aggiungo al container
		contentPane.add(pannelloBottoni);
	}

	/**
	 * Key pressed.
	 *
	 * @param k the k
	 */
	// metodi non utili
	public void keyPressed(KeyEvent k) {
	}

	/**
	 * Key released.
	 *
	 * @param k the k
	 */
	public void keyReleased(KeyEvent k) {
	}

	/**
	 * Key typed.
	 *
	 * @param k the k
	 */
	public void keyTyped(KeyEvent k) {
		// Ottengo il carattere
		char carattere = k.getKeyChar();
		if (carattere == 'b') {
			contatoreBottoni++;
			// aggiungo il bottone
			aggiungiBottone();
		}
	}

	/**
	 * Aggiungi bottone.
	 */
	private void aggiungiBottone() {
		// Creo il bottone con un certo nome e...
		JButton bottone = new JButton("B " + contatoreBottoni);
		// ... lo aggiungo al pannello bottoni
		pannelloBottoni.add(bottone);

		pannelloBottoni.validate(); // Indispensabile all'aggiornamento
		// del layout, chiama da solo il repaint
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new LayoutFlowFrame_a1();
		frame.setVisible(true);
	}
}
