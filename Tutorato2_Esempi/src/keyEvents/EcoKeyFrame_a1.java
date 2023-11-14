package keyEvents;

import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra come un Frame registra gli eventi della tastiera.
//L'output viene inviato a linea di comando
public class EcoKeyFrame_a1 extends JFrame {
	public EcoKeyFrame_a1() {
		setTitle("frame per vedere gli eventi tastiera");
		setSize(300, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		KeyListener ascoltatore = new AscoltaTastiera_a1();
		addKeyListener(ascoltatore);
	}

	public static void main(String[] args) {
		JFrame frame = new EcoKeyFrame_a1();
		frame.setVisible(true);
	}
}

//Implemento KeyListener
class AscoltaTastiera_a1 implements KeyListener {
	public void keyPressed(KeyEvent k) {
		// Recupero il codice del tasto premuto e lo stampo
		int codiceTasto = k.getKeyCode();
		System.out.print("premuto il tasto " + codiceTasto);

		// Stampo la descrizione del tasto premuto
		System.out.println(" tale codice corrisponde al tasto virtuale \"VK_" + k.getKeyText(codiceTasto) + "\"");
	}

	public void keyReleased(KeyEvent k) {
		// Recupero il codice del tasto rilasciato e lo stampo
		int codiceTasto = k.getKeyCode();
		System.out.print("rilasciato il tasto " + codiceTasto);

		// Stampo la descrizione del tasto rilasciato
		System.out.println(" tale codice corrisponde al tasto virtuale \"VK_" + k.getKeyText(codiceTasto) + "\"");
	}

	public void keyTyped(KeyEvent k) {
		// Stampo il carattere digitato
		System.out.println("completata la digitazione del carattere \'" + k.getKeyChar() + "\'");
	}
}
