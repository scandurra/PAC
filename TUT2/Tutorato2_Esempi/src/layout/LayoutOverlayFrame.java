package layout;

import java.awt.*;
import javax.swing.*;

//Questo esempio mostra un OverlayLayout all'opera
public class LayoutOverlayFrame extends JFrame {
	public LayoutOverlayFrame() {
		// Imposto il JFrame
		setTitle("OverlayLayout all'opera");
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Imposto il layout (notare sintassi differenza)
		OverlayLayout overlay = new OverlayLayout(getContentPane());
		getContentPane().setLayout(overlay);

		// aggiungo pannelli ai "punti cardinali"
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(new JButton("N"), BorderLayout.NORTH);
		panel1.add(new JButton("S"), BorderLayout.SOUTH);
		panel1.add(new JButton("E"), BorderLayout.EAST);
		panel1.add(new JButton("W"), BorderLayout.WEST);
		getContentPane().add(panel1);

		// Imposto un JPanel con layout di tipo Flow e un certo valore di GAP
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
		// aggiungo 3 bottoni
		panel2.add(new JButton("A"));
		panel2.add(new JButton("B"));
		panel2.add(new JButton("C"));
		getContentPane().add(panel2);

	}

	public static void main(String[] args) {
		JFrame frame = new LayoutOverlayFrame();
		frame.setVisible(true);
	}
}
