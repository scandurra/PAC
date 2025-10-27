package scelte;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The Class RadioFrame.
 * 
 * Questo esempio mostra come utilizzare i radiobutton.
 */
public class RadioFrame extends JFrame {

	/**
	 * Instantiates a new radio frame.
	 */
	public RadioFrame() {
		// Preparo il JFrame
		setTitle("Disegno poligoni regolari");
		setSize(500, 500);
		setLocation(30, 20);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		// aggiungo il RadioPanel
		contentPane.add(new RadioPanel(), BorderLayout.CENTER);

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new RadioFrame();
		frame.setVisible(true);
	}
}

class RadioPanel extends JPanel implements ActionListener {
	JRadioButton lati4, lati8, lati16;
	private PoligonoPanel disegno;

	public RadioPanel() {
		setLayout(new BorderLayout());

		// Creo i pannelli che comporranno il pannello
		JPanel pulsanti = new JPanel();
		disegno = new PoligonoPanel(true, false, false);

		// Creo le radiobutton
		lati4 = new JRadioButton("quadrato", true);
		lati8 = new JRadioButton("ottagono", false);
		lati16 = new JRadioButton("16-gono", false);

		// Aggiungo i pulsanti ad un gruppo
		// NB solo in questo modo la scelta risulta poi mutuamente esclusiva!
		ButtonGroup gruppo = new ButtonGroup();
		gruppo.add(lati4);
		gruppo.add(lati8);
		gruppo.add(lati16);

		// Aggiungo il listener
		lati4.addActionListener(this);
		lati8.addActionListener(this);
		lati16.addActionListener(this);

		// Aggiungo i radiobutton al pannello dei pulsanti
		pulsanti.add(lati4);
		pulsanti.add(lati8);
		pulsanti.add(lati16);

		// Aggiungo i pannelli al pannello principale
		add(pulsanti, BorderLayout.SOUTH);
		add(disegno, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		// Devo controllare lo stato della scelta delle opzioni
		// ed agire di conseguenza
		// NB: la "politica" di scelta � data dal tipo di bottoni (muamente esclusiva o
		// no)
		disegno.traccio4 = lati4.isSelected();
		disegno.traccio8 = lati8.isSelected();
		disegno.traccio16 = lati16.isSelected();
		// Ridisegno
		disegno.repaint();
	}

}
