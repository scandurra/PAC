package mouseEvents;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * The Class CursorFrame.
 * 
 * Questo esempio mostra come modificare il cursore del mouse
 * il pannello ascolta i movimenti del mouse.
 * In base alla posizione del mouse cambia la forma del cursore.
 */
public class CursorFrame extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new cursor frame.
	 */
	public CursorFrame() {
		setTitle("Frame per vedere i cursori del mouse");
		setSize(600, 600);
		setLocation(50, 50);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Creo il container
		Container contentPane = getContentPane();
		// Creo il pannello
		CursorPanel pannello = new CursorPanel();
		// aggiungo il pannello al container
		contentPane.add(pannello);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new CursorFrame();
		frame.setVisible(true);
	}
}

class CursorPanel extends JPanel implements MouseMotionListener {
	// punti notevoli del pannello, in base a questi cambier� la forma del cursore
	private int xRect = 10, yRect = 10, wRect = 100, hRect = 100;
	private int xOval = 200, yOval = 100, rOval = 50;
	private int xRect2 = 300, yRect2 = 200, wRect2 = 100, hRect2 = 100;
	private int xOval2 = 500, yOval2 = 500, rOval2 = 50;
	private Cursor custom;

	public CursorPanel() {
		// Recupero il Toolkit di default
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		// Recupero l'immagine del cursore custom tramite il Toolkit
		Image img = toolkit.getImage("src/mouseEvents/cursor.gif");

		// Attendo finche' l'immagine non e' stata completamente caricata
		MediaTracker tracker = new MediaTracker(this);
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
		}

		// Creo il cursore custom
		custom = toolkit.createCustomCursor(img, new Point(3, 29), "");

		addMouseMotionListener(this);

		setBackground(Color.white);
	}

	// Disegna le aree sensibili
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawRect(xRect, yRect, wRect, hRect);
		g.drawOval(xOval - rOval, yOval - rOval, 2 * rOval, 2 * rOval);
		g.drawRect(xRect2, yRect2, wRect2, hRect2);
		g.drawOval(xOval2 - rOval2, yOval2 - rOval2, 2 * rOval2, 2 * rOval2);
		int w = getWidth();
		int h = getHeight();
		g.drawRect(0, h - 10, w, 9);
		g.drawRect(w - 10, 0, 9, h);
	}

	// A seconda di dove si trova il mouse attivo un cursore speciale
	// individuo la zona confrontando la posizione del mouse e le aree sensibili
	public void mouseMoved(MouseEvent e) {
		// ottengo la posizione del mouse
		Point p = e.getPoint();

		if (xRect <= p.x && p.x < xRect + wRect && yRect <= p.y && p.y < yRect + hRect)
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		else if (xRect2 <= p.x && p.x < xRect2 + wRect2 && yRect2 <= p.y && p.y < yRect2 + hRect2)
			setCursor(new Cursor(Cursor.WAIT_CURSOR));
		else if (Math.sqrt((p.x - xOval) * (p.x - xOval) + (p.y - yOval) * (p.y - yOval)) < rOval)
			setCursor(new Cursor(Cursor.HAND_CURSOR));
		else if (Math.sqrt((p.x - xOval2) * (p.x - xOval2) + (p.y - yOval2) * (p.y - yOval2)) < rOval2)
			setCursor(custom);
		else if (getWidth() - 10 < p.x && getHeight() - 10 < p.y)
			setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
		else if (getWidth() - 10 < p.x)
			setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
		else if (getHeight() - 10 < p.y)
			setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
		else
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}

	// Implementazione vuota, lo richiede l'interfaccia
	public void mouseDragged(MouseEvent e) {
		/* ... */}
}
