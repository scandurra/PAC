package mouseEvents;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra come un panel registra gli eventi del mouse.
//L'output viene inviato al pannello
public class EcoMouseFrame_a3 extends JFrame {
	private static final long serialVersionUID = 1L;

	public EcoMouseFrame_a3() {
		setTitle("frame per vedere gli eventi mouse");
		setSize(500, 500);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// creo il container
		Container contentPane = getContentPane();
		// Creo il pannello
		EcoMousePanel_a3 pannello = new EcoMousePanel_a3();
		// lo aggiungo al container
		contentPane.add(pannello);
	}

	public static void main(String[] args) {
		JFrame frame = new EcoMouseFrame_a3();
		frame.setVisible(true);
	}
}

//Creo un panel che si autoascolta (infatti implementa l'interfaccia del listener)
class EcoMousePanel_a3 extends JPanel implements MouseMotionListener {
	public EcoMousePanel_a3() {
		addMouseMotionListener(this); // Il pannello ascolta se stesso
		setBackground(Color.white);
		setForeground(Color.black);
	}

	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse trascinato a partire dal punto " + e.getPoint());
		int x = e.getX();
		int y = e.getY();

		// Ricavo un contesto grafico
		Graphics g = getGraphics();

		g.setColor(Color.yellow);
		g.fillRect(x, y, 10, 10);
		g.dispose(); // Altrimenti mi ritroverei con troppi contesti grafici
	}

	public void mouseMoved(MouseEvent e) {
		System.out.println("Mouse moved a partire dal punto " + e.getPoint());
		int x = e.getX();
		int y = e.getY();
		// Ricavo un contesto grafico
		Graphics g = getGraphics();

		g.setColor(Color.magenta);
		g.fillRect(x, y, 7, 7);
		g.dispose(); // Altrimenti mi ritroverei con troppi contesti grafici
	}
}
