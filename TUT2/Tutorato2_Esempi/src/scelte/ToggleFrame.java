package scelte;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra come utilizzare i togglebutton
public class ToggleFrame extends JFrame {
	public ToggleFrame() {
		// Preparo il JFrame
		setTitle("disegno poligoni regolari");
		setSize(500, 500);
		setLocation(30, 20);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		// aggiungo il TogglePanel
		contentPane.add(new TogglePanel(), BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame frame = new ToggleFrame();
		frame.setVisible(true);
	}
}

class TogglePanel extends JPanel implements ActionListener {
	private JToggleButton lati4, lati8, lati16;
	private PoligonoPanel disegno; // Questa classe e' definita nel file CheckFrame

	public TogglePanel() {
		setLayout(new BorderLayout());

		// Creo i pannelli che comporranno il pannello
		JPanel pulsanti = new JPanel();
		disegno = new PoligonoPanel(true, true, true);

		// Creo i togglebutton
		lati4 = new JToggleButton("quadrato", true);
		lati8 = new JToggleButton("ottagono", true);
		lati16 = new JToggleButton("16-gono", true);

		// Aggiungo il listener
		lati4.addActionListener(this);
		lati8.addActionListener(this);
		lati16.addActionListener(this);

		// Aggiungo i checkbox al pannello dei pulsanti
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