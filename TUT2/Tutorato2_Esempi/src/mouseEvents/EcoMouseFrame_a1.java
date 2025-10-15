package mouseEvents;

import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra come un Frame registra gli eventi del mouse.
//L'output viene inviato alla console
public class EcoMouseFrame_a1 extends JFrame {
	private static final long serialVersionUID = 1L;

	public EcoMouseFrame_a1() {
		setTitle("frame per vedere gli eventi mouse");
		setSize(500, 500);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Associo un listener custom
		addMouseListener(new AscoltatoreMouse_a1());
	}

	public static void main(String[] args) {
		JFrame frame = new EcoMouseFrame_a1();
		frame.setVisible(true);
	}
}

//Listener custom che implementa l'interfaccia 
class AscoltatoreMouse_a1 implements MouseListener {
	public void mouseClicked(MouseEvent e) {
		System.out.print("E' stato cliccato il mouse ");
		System.out.println("mentre era premuto il bottone " + e.getButton());
		System.out.println("sono stati fatti n." + e.getClickCount() + " click");
		System.out.println("si era sul punto di coordinate x= " + e.getX() + " y= " + e.getY());
		System.out.println();
	}

	public void mouseEntered(MouseEvent e) {
		System.out.print("Il mouse e' entrato nella componente frame ");
		System.out.println("mentre era premuto il bottone " + e.getButton());
		System.out.println("sono stati fatti n." + e.getClickCount() + " click");
		System.out.println("si era sul punto di coordinate x= " + e.getX() + " y= " + e.getY());
		System.out.println();
	}

	public void mouseExited(MouseEvent e) {
		System.out.print("Il mouse e' uscito dalla componente frame ");
		System.out.println("mentre era premuto il bottone " + e.getButton());
		System.out.println("sono stati fatti n." + e.getClickCount() + " click");
		System.out.println("si era sul punto di coordinate x= " + e.getX() + " y= " + e.getY());
		System.out.println();
	}

	public void mousePressed(MouseEvent e) {
		System.out.print("E' stato premuto ");
		System.out.println("il bottone " + e.getButton());
		System.out.println("si era sul punto di coordinate x= " + e.getX() + " y= " + e.getY());
		System.out.println();
	}

	public void mouseReleased(MouseEvent e) {
		System.out.print("E' stato rilasciato ");
		System.out.println("il bottone " + e.getButton());
		System.out.println("si era sul punto di coordinate x= " + e.getX() + " y= " + e.getY());
		System.out.println();
	}
}
