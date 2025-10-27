package layout;

import java.awt.*;
import javax.swing.*;

/**
 * The Class LayoutGridFrame.
 * 
 * Questo esempio mostra un GridLayout all'opera
 */
public class LayoutGridFrame extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new layout grid frame.
	 */
	public LayoutGridFrame() {
		// Imposto il frame
		setTitle("GridLayout all'opera");
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Creo il container e imposto il layout
		Container contentPane = getContentPane();
		// griglia 3x3 con gap di 10 in orizzontale e 10 in verticale
		contentPane.setLayout(new GridLayout(3, 3, 10, 10));
		// Ho 9 celle a disposizione, inserisco 8 pannelli di dimensioni fisse ma colore
		// random
		for (int i = 0; i < 8; i++) {
			JPanel p = new JPanel();
			p.setBackground(new Color(35 * i % 256, 175 * i % 256, 130 * i % 256));
			contentPane.add(p);
		}
		// inserisco un bottone all'ultima posizione
		JButton bottone = new JButton("Un bottone");
		contentPane.add(bottone);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new LayoutGridFrame();
		frame.setVisible(true);
	}
}
