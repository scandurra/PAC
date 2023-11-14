package layout;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra un FlowLayout all'opera
//Ogni volta che sulla tastiera schiaccio il carattere 
//'p' si aggiunge un nuovo pannello colorato
//implemento il KeyListener per "ascoltare" i tasti da tastiera 
public class LayoutFlowFrame_a2 extends JFrame implements KeyListener {

	// Pannello contenitore di pannelli
	private JPanel pannelloPannelli;
	private int contatorePannelli = 0;

	public LayoutFlowFrame_a2() {
		// Imposto il JFrame
		setTitle("FlowLayout all'opera");
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Implemento nel JFrame il listener
		addKeyListener(this);
		// Creo un container
		Container contentPane = getContentPane();
		// Inizializzo il contenitore di pannelli
		pannelloPannelli = new JPanel();
		// Imposto il layout
		pannelloPannelli.setLayout(new FlowLayout());
		// COSA SUCCEDEREBBE SE IL LAYOUT FOSSE DIVERSO?
		// pannelloPannelli.setLayout(new BorderLayout());
		// pannelloPannelli.setLayout(new GridLayout(10, 10, 5, 5));
		// lo aggiungo al container
		contentPane.add(pannelloPannelli);
	}

	public void keyPressed(KeyEvent k) {
	}

	public void keyReleased(KeyEvent k) {
	}

	public void keyTyped(KeyEvent k) {
		// Ottengo il carattere premuto
		char carattere = k.getKeyChar();
		if (carattere == 'p') {
			contatorePannelli++;
			aggiungiPannello();
		}
	}

	private void aggiungiPannello() {
		// Creo un nuovo JPanel
		JPanel pannello = new JPanel();
		// Imposto dimensioni e sfondo random
		pannello.setPreferredSize(new Dimension((int) (Math.random() * 100) + 10, (int) (Math.random() * 100) + 10));
		pannello.setBackground(new Color((float) Math.random(), (float) Math.random(), (float) Math.random()));
		// lo aggiungo
		pannelloPannelli.add(pannello);
		pannelloPannelli.validate(); // Indispensabile all'aggiornamento del layout, chiama da solo il repaint
	}

	public static void main(String[] args) {
		JFrame frame = new LayoutFlowFrame_a2();
		frame.setVisible(true);
	}
}
