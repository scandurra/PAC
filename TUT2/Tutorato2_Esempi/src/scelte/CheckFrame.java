package scelte;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The Class CheckFrame.
 * 
 * Questo esempio mostra come utilizzare le checkbox.
 */
public class CheckFrame extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new check frame.
	 */
	public CheckFrame() {
		// Imposto il JFrame e aggiungo il CheckPanel
		setTitle("Disegno poligoni regolari");
		setSize(500, 500);
		setLocation(30, 20);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.add(new CheckPanel(), BorderLayout.CENTER);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new CheckFrame();
		frame.setVisible(true);
	}
}

//Imposto il CheckPanel e implemento l'ActionListener per le azioni sui CheckBox
class CheckPanel extends JPanel implements ActionListener {
	private JCheckBox lati4, lati8, lati16;
	private PoligonoPanel pannelloPoligoni;

	public CheckPanel() {
		// Imposto il layout
		setLayout(new BorderLayout());

		// Creo i pannelli che comporranno il pannello
		JPanel pulsanti = new JPanel(); // Pannello pulsanti
		pannelloPoligoni = new PoligonoPanel(true, true, true); // Pannello disegno poligono

		// Creo le checkbox
		lati4 = new JCheckBox("quadrato", true);
		lati8 = new JCheckBox("ottagono", true);
		lati16 = new JCheckBox("16-gono", true);

		// Imposto lo stato iniziale dei CheckBox
		lati4.setSelected(true);
		lati8.setSelected(false);
		lati16.setSelected(false);

		// Aggiungo il listener alle checkbox
		lati4.addActionListener(this);
		lati8.addActionListener(this);
		lati16.addActionListener(this);

		// Aggiungo i checkbox al pannello dei pulsanti
		pulsanti.add(lati4);
		pulsanti.add(lati8);
		pulsanti.add(lati16);

		// Aggiungo i pannelli al pannello principale
		add(pulsanti, BorderLayout.SOUTH);
		add(pannelloPoligoni, BorderLayout.CENTER);
		
		pannelloPoligoni.traccio4 = lati4.isSelected();
		pannelloPoligoni.traccio8 = lati8.isSelected();
		pannelloPoligoni.traccio16 = lati16.isSelected();
		// Ridisegno
		pannelloPoligoni.repaint();
	}

	// implemento il gestore di eventi del JCheckBox
	public void actionPerformed(ActionEvent e) {
		// Devo controllare lo stato della scelta delle opzioni
		// ed agire di conseguenza
		// NB: la "politica" di scelta + data dal tipo di bottoni (muamente esclusiva o
		// no)
		pannelloPoligoni.traccio4 = lati4.isSelected();
		pannelloPoligoni.traccio8 = lati8.isSelected();
		pannelloPoligoni.traccio16 = lati16.isSelected();
		// Ridisegno
		pannelloPoligoni.repaint();
	}
}

class PoligonoPanel extends JPanel {
	public boolean traccio4, traccio8, traccio16;

	public PoligonoPanel(boolean t4, boolean t8, boolean t16) {
		traccio4 = t4;
		traccio8 = t8;
		traccio16 = t16;
	}

	// Ridefinisco il metodo paintComponent per disegnare
	public void paintComponent(Graphics g) {
		// Chiamo il metodo della superclasse
		super.paintComponent(g);
		// sfondo bianco
		setBackground(Color.white);

		// Ottengo le dimensioni e disegno la circonferenza di sfondo
		Dimension d = getSize();
		int raggio = ((d.width > d.height) ? (d.height) / 2 : (d.width) / 2) - 10; // scelgo il raggio
		g.drawOval((d.width - 2 * raggio) / 2, (d.height - 2 * raggio) / 2, 2 * raggio, 2 * raggio);
		int centroX = (d.width - 2 * raggio) / 2 + raggio;
		int centroY = (d.height - 2 * raggio) / 2 + raggio;

		// se devo tracciare un quadrato
		if (traccio4) {
			g.setColor(Color.green);
			Polygon p = this.creaPoligono(centroX, centroY, raggio, 4);
			g.drawPolygon(p);
		}

		// se devo tracciare un ottagono
		if (traccio8) {
			g.setColor(Color.red);
			Polygon p = this.creaPoligono(centroX, centroY, raggio, 8);
			g.drawPolygon(p);
		}

		// se devo tracciare un 16-gono
		if (traccio16) {
			g.setColor(Color.magenta);
			Polygon p = this.creaPoligono(centroX, centroY, raggio, 16);
			g.drawPolygon(p);
		}
	}

	// metodo che crea i poligoni (il disegno lo faccio nel paintComponent)
	private Polygon creaPoligono(int x, int y, int raggio, int lati) {
		// Vettori delle coordinate
		int[] xCoord = new int[lati];
		int[] yCoord = new int[lati];
		for (int i = 0; i < lati; i++) {
			// angolo
			double angolo = 2 * Math.PI / lati * i;
			// generazione coordinate
			xCoord[i] = x + (int) (raggio * Math.cos(angolo));
			yCoord[i] = y + (int) (raggio * Math.sin(angolo));
		}

		// Creazione del poligono da restituire
		return new Polygon(xCoord, yCoord, lati);
	}
}
