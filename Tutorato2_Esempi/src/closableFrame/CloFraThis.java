package closableFrame;

import javax.swing.*;
import java.awt.event.*;

//Secondo sistema per chiudere l'applicazione al chiudersi del Frame
//tramite i listener
public class CloFraThis extends CloseableFrame implements WindowListener {
	private static final long serialVersionUID = 1L;

	public CloFraThis() {
		// Imposto la classe stessa come suo listener
		addWindowListener(this);
	}

	// MAIN
	public static void main(String[] args) {
		JFrame frame = new CloFraThis();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("chiudo la finestra!!!");
		System.exit(0);
	}

	// Metodi da implementare obbligatoriamente (interfaccia) anche se
	// non sono interessato a gestire quel tipo di eventi
	@Override
	public void windowActivated(WindowEvent e) {
		/* ... */}

	@Override
	public void windowClosed(WindowEvent e) {
		/* ... */}

	@Override
	public void windowDeactivated(WindowEvent e) {
		/* ... */}

	@Override
	public void windowDeiconified(WindowEvent e) {
		/* ... */}

	@Override
	public void windowIconified(WindowEvent e) {
		/* ... */}

	@Override
	public void windowOpened(WindowEvent e) {
		/* ... */}
}
