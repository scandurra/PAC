package closableFrame;

import javax.swing.*;
import java.awt.event.*;

/**
 * The Class CloFraThis.
 * Secondo sistema per chiudere l'applicazione al chiudersi del Frame tramite i listener
 */
public class CloFraThis extends CloseableFrame implements WindowListener {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new clo fra this.
	 */
	public CloFraThis() {
		// Imposto la classe stessa come suo listener
		addWindowListener(this);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// MAIN
	public static void main(String[] args) {
		JFrame frame = new CloFraThis();
	}

	/**
	 * Window closing.
	 *
	 * @param e the e
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Chiudo la finestra!!!");
		System.exit(0);
	}

	// Metodi da implementare obbligatoriamente (interfaccia) anche se
	/**
	 * Window activated.
	 *
	 * @param e the e
	 */
	// non sono interessato a gestire quel tipo di eventi
	@Override
	public void windowActivated(WindowEvent e) {
		/* ... */}

	/**
	 * Window closed.
	 *
	 * @param e the e
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		/* ... */}

	/**
	 * Window deactivated.
	 *
	 * @param e the e
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		/* ... */}

	/**
	 * Window deiconified.
	 *
	 * @param e the e
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		/* ... */}

	/**
	 * Window iconified.
	 *
	 * @param e the e
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		/* ... */}

	/**
	 * Window opened.
	 *
	 * @param e the e
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		/* ... */}
}
