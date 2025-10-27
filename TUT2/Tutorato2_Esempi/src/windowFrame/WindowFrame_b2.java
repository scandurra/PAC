package windowFrame;

import javax.swing.*;
import java.awt.event.*;

/**
 * The Class WindowFrame_b2.
 * 
 * Questo esempio mostra una finestra che manda un messaggio alla chiusura
 * usa il WindowAdapter lo definisce "al volo" in modo anonimo e ridefinisce 
 * solo il metodo di interesse
 */
public class WindowFrame_b2 extends JFrame {

	/**
	 * Instantiates a new window frame b 2.
	 */
	public WindowFrame_b2() {
		setTitle("finestra cavia");
		setSize(300, 200);
		setLocation(300, 200);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("la finestra si sta chiudendo");
				System.exit(0);
			}
		});
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// Main
	public static void main(String[] args) {
		JFrame frame = new WindowFrame_b2();
		frame.setVisible(true);
	}
}
