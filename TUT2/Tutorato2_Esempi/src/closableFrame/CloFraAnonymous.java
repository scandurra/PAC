package closableFrame;

import javax.swing.*;
import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CloFraAnonymous.
 * Sistema per chiudere l'applicazione al chiudersi del Frame tramite i listener
 */
public class CloFraAnonymous extends CloseableFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new clo fra anonymous.
	 */
	public CloFraAnonymous() {

		// Imposto il listener anonimo, lo dichiaro massandolo al metodo
		addWindowListener(new WindowListener() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Chiudo la finestra!!!");
				System.exit(0);
			}

			// Metodi da implementare obbligatoriamente (interfaccia) anche se
			// non sono interessato a gestire quel tipo di eventi
			@Override
			public void windowActivated(WindowEvent e) {
				/* ... */ }

			@Override
			public void windowClosed(WindowEvent e) {
				/* ... */ }

			@Override
			public void windowDeactivated(WindowEvent e) {
				/* ... */ }

			@Override
			public void windowDeiconified(WindowEvent e) {
				/* ... */ }

			@Override
			public void windowIconified(WindowEvent e) {
				/* ... */ }

			@Override
			public void windowOpened(WindowEvent e) {
				/* ... */ }

		});
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// MAIN
	public static void main(String[] args) {
		JFrame frame = new CloFraAnonymous();
	}
}
