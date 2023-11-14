package layout;

import java.awt.*;
import javax.swing.*;

//Questo esempio mostra un mix di Flow e Border
public class LayoutBorderFrame_a2 extends JFrame {
	public LayoutBorderFrame_a2() {
		setTitle("Layout vari all'opera");
		// Imposto dimensioni e posizione
		setSize(600, 450);
		setLocation(30, 20);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Creo 5 JPanel e a ciascuno imposto il colore di background
		JPanel A, B, C, D, E;
		A = new JPanel();
		A.setBackground(Color.red);

		B = new JPanel();
		B.setBackground(Color.blue);

		C = new JPanel();
		C.setBackground(Color.green);

		D = new JPanel();
		D.setBackground(Color.yellow);

		E = new JPanel();
		E.setBackground(Color.magenta);

		// imposto il layout del primo JPanel e aggiungo dei bottoni nei punti cardinali
		A.setLayout(new BorderLayout());
		A.add(new JButton("A1"), BorderLayout.WEST);
		A.add(new JButton("A2"), BorderLayout.CENTER);
		A.add(new JButton("A3"), BorderLayout.EAST);

		// imposto il layout del secondo JPanel con vgap e hgap e aggiungo bottoni
		// hgap imposta la distanza in verticale tra gli oggetti inseriti nel JPanel
		// Si vedr� il colore dello sfondo tra i bottoni
		B.setLayout(new BorderLayout(10, 10));
		B.add(new JButton("B1"), BorderLayout.NORTH);
		B.add(new JButton("B2"), BorderLayout.CENTER);
		B.add(new JButton("B3"), BorderLayout.SOUTH);

		// Imposto il layout del terzo JPanel e aggiungo bottoni
		C.setLayout(new BorderLayout());
		C.add(new JButton("C1"), BorderLayout.WEST);
		C.add(new JButton("C2"), BorderLayout.CENTER);
		C.add(new JButton("C3"), BorderLayout.EAST);

		// NON imposto il layout del quarto, aggiungo i bottoni come li aggiungerei
		// con il layout absolute
		D.add(new JButton("D1"));
		D.add(new JButton("D2"));
		D.add(new JButton("D3"));
		D.add(new JButton("D4"));

		// imposto il layout del quinto JPanel e aggiungo due bottoni.
		// Dato il valore di vgap maggiore di 0 vedr� lo sfondo tra i bottoni
		E.setLayout(new BorderLayout(25, 25));
		E.add(new JButton("E1"), BorderLayout.NORTH);
		E.add(new JButton("E2"), BorderLayout.SOUTH);

		// Creo un container
		Container contentPane = getContentPane();
		// Aggiungo i JPanel al container sfruttando i punti cardinali offerti dal
		// layout
		contentPane.add(A, BorderLayout.NORTH);
		contentPane.add(B, BorderLayout.SOUTH);
		contentPane.add(C, BorderLayout.EAST);
		contentPane.add(D, BorderLayout.WEST);
		contentPane.add(E, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		JFrame frame = new LayoutBorderFrame_a2();
		frame.setVisible(true);
	}
}
