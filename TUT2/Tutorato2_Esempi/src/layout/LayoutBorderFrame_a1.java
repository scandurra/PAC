package layout;

import java.awt.*;
import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class LayoutBorderFrame_a1.
 */
//Questo esempio mostra un BorderLayout all'opera
public class LayoutBorderFrame_a1 extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new layout border frame a 1.
	 */
	public LayoutBorderFrame_a1() {
		setTitle("BorderLayout all'opera");
		// Imposto dimensioni e posizione
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// creo 5 JPanel e per ciascuno di essi imposto dimensioni e colore.
		JPanel A, B, C, D, E;

		A = new JPanel();
		A.setBackground(Color.red);
		A.setPreferredSize(new Dimension(60, 30));

		B = new JPanel();
		B.setBackground(Color.blue);
		B.setPreferredSize(new Dimension(60, 30));

		C = new JPanel();
		C.setBackground(Color.green);
		C.setPreferredSize(new Dimension(60, 60));

		D = new JPanel();
		D.setBackground(Color.yellow);
		D.setPreferredSize(new Dimension(60, 60));

		E = new JPanel();
		E.setBackground(Color.magenta);

		// Aggiungo i JPanel ai "punti cardinali" del frame.
		// ottengo tali punti dai campi del layout
		add(A, BorderLayout.NORTH);
		add(B, BorderLayout.SOUTH);
		add(C, BorderLayout.EAST);
		add(D, BorderLayout.WEST);
		add(E, BorderLayout.CENTER);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new LayoutBorderFrame_a1();
		frame.setVisible(true);
	}
}
