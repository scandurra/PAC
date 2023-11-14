package windowFrame;

import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra la gestione degli eventi di finestra
public class WindowFrame_a1 extends JFrame {
	public WindowFrame_a1() {
		setTitle("finestra cavia");
		setSize(300, 200);
		setLocation(300, 200);
		// Aggiungiamo un listener degli eventi del frame direttamente al frame
		// realizzato con una classe custom che implementa l'interfaccia WindowListener
		// vedi sotto nello stesso file
		AscoltatoreEventiFrame_a1 mioAscoltatore = new AscoltatoreEventiFrame_a1();
		addWindowListener(mioAscoltatore);
	}

	public static void main(String[] args) {
		JFrame frame = new WindowFrame_a1();
		frame.setVisible(true);
	}
}

//Il Listener degli eventi del Frame,
//implementa l'interface WindowListener 
//che prevede sette metodi differenti
class AscoltatoreEventiFrame_a1 implements WindowListener {
	public void windowClosing(WindowEvent e) {
		System.out.println("la finestra si sta chiudendo");
		((JFrame) e.getSource()).dispose();
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("la finestra si e' chiusa");
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("la finestra e' ora una icona");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("la finestra e' passata da icona a finestra");
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("la finestra e' stata aperta");
	}

	public void windowActivated(WindowEvent e) {
		System.out.println("la finestra e' la componente attiva");
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("la finestra e' divenuta inattiva");
	}
}
