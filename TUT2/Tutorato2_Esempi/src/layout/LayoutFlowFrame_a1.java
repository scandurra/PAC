package layout;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra un FlowLayout all'opera.
//Ogni volta che sulla tastiera premo il carattere 
//'b' si aggiunge un nuovo bottone
//Implemento KeyListener per "ascoltare" i pulsanti premuti da tastiera
public class LayoutFlowFrame_a1 extends JFrame implements KeyListener {
	// Creo il JPanel che conterr� i bottoni
	private JPanel pannelloBottoni;
	private int contatoreBottoni = 0;

	// Costruttore
	public LayoutFlowFrame_a1() {
		// imposto titolo, misure e posizione
		setTitle("FlowLayout all'opera");
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

	// metodi non utili
	public void keyPressed(KeyEvent k) {
	}

	public void keyReleased(KeyEvent k) {
	}

	public void keyTyped(KeyEvent k) {
		// Ottengo il carattere
		char carattere = k.getKeyChar();
		if (carattere == 'b') {
			contatoreBottoni++;
			// aggiungo il bottone
			aggiungiBottone();
		}
	}

	private void aggiungiBottone() {
		// Creo il bottone con un certo nome e...
		JButton bottone = new JButton("B " + contatoreBottoni);
		// ... lo aggiungo al pannello bottoni
		pannelloBottoni.add(bottone);

		pannelloBottoni.validate(); // Indispensabile all'aggiornamento
		// del layout, chiama da solo il repaint
	}

	public static void main(String[] args) {
		JFrame frame = new LayoutFlowFrame_a1();
		frame.setVisible(true);
	}
}
