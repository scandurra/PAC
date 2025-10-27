package keyEvents;

import javax.swing.*;
import java.awt.event.*;

/**
 * The Class EcoKeyFrame_a1.
 * Questo esempio mostra come un Frame registra gli eventi della tastiera.
 * L'output viene inviato a linea di comando
 */

public class EcoKeyFrame_a1 extends JFrame {
	
	private static JLabel label = new JLabel("Hello, Swing!"); // Create a label with text
    
	/**
	 * Instantiates a new eco key frame a 1.
	 */
	public EcoKeyFrame_a1() {
		setTitle("Frame per vedere gli eventi tastiera");
		setSize(300, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		KeyListener ascoltatore = new AscoltaTastiera_a1(label);
		addKeyListener(ascoltatore);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new EcoKeyFrame_a1();
		frame.setVisible(true);
		
        label.setBounds(50, 50, 150, 30); // Set position and size

        // Update the label text
        label.setText("Welcome to Java Swing!");

        frame.add(label);
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//Implemento KeyListener
class AscoltaTastiera_a1 implements KeyListener {
	
    private static JLabel label = new JLabel("");

	public AscoltaTastiera_a1(JLabel lbl) {
		label = lbl;
	}
	
	public void keyPressed(KeyEvent k) {
		// Recupero il codice del tasto premuto e lo stampo
		int codiceTasto = k.getKeyCode();
		label.setText("Premuto tasto " + codiceTasto + " (VK_" + k.getKeyText(codiceTasto) + ")");
		System.out.print("Premuto il tasto " + codiceTasto);

		// Stampo la descrizione del tasto premuto
		System.out.println(" tale codice corrisponde al tasto virtuale \"VK_" + k.getKeyText(codiceTasto) + "\"");
	}

	public void keyReleased(KeyEvent k) {
		// Recupero il codice del tasto rilasciato e lo stampo
		int codiceTasto = k.getKeyCode();
		label.setText("Rilasciato tasto " + codiceTasto);
		System.out.print("Rilasciato il tasto " + codiceTasto);

		// Stampo la descrizione del tasto rilasciato
		System.out.println(" tale codice corrisponde al tasto virtuale \"VK_" + k.getKeyText(codiceTasto) + "\"");
	}

	public void keyTyped(KeyEvent k) {
		// Stampo il carattere digitato
		label.setText("Completata digitazione carattere tasto \'" + k.getKeyChar() + "\'");
		System.out.println("Completata la digitazione del carattere \'" + k.getKeyChar() + "\'");
	}
}
