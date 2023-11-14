package border;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

//Questo esempio mostra tanti bordi
public class BorderFrame extends JFrame {
	public BorderFrame() {
		// Imposto il JFrame
		setTitle("festival di bordi");
		setSize(500, 550);
		setLocation(200, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Imposto il container
		Container contentPane = getContentPane();
		// Imposto il layout a griglia 3x3
		contentPane.setLayout(new GridLayout(3, 3));

		// Creo 9 pannelli con cornici diverse

		// PRIMO PANNELLO - bordo colorato
		Border linea = BorderFactory.createLineBorder(Color.red);
		JPanel p1 = new JPanel();
		p1.setBorder(linea);
		contentPane.add(p1);

		// SECONDO PANNELLO - bordo colorato spesso
		Border lineaSpessa = BorderFactory.createLineBorder(Color.blue, 5);
		JPanel p2 = new JPanel();
		p2.setBorder(lineaSpessa);
		contentPane.add(p2);

		// TERZO PANNELLO - bordo infossato
		Border cornice = BorderFactory.createLoweredBevelBorder();
		JPanel p3 = new JPanel();
		p3.setBorder(cornice);
		contentPane.add(p3);

		// QUARTO PANNELLO - bordo inciso
		Border incisa = BorderFactory.createEtchedBorder(Color.black, Color.yellow);
		JPanel p4 = new JPanel();
		p4.setBorder(incisa);
		contentPane.add(p4);

		// QUINTO PANNELLO - bordo con titolo
		TitledBorder linea2 = BorderFactory.createTitledBorder(linea, "quinto pannello");
		JPanel p5 = new JPanel();
		p5.setBorder(linea2);
		contentPane.add(p5);

		// SESTO PANNELLO - bordo colorato spesso con titolo
		Border lineaSpessa2 = BorderFactory.createTitledBorder(lineaSpessa, "sesto pannello");
		JPanel p6 = new JPanel();
		p6.setBorder(lineaSpessa2);
		contentPane.add(p6);

		// SETTIMO PANNELLO - infossato con titolo
		Border cornice2 = BorderFactory.createTitledBorder(cornice, "settimo pannello");
		JPanel p7 = new JPanel();
		p7.setBorder(cornice2);
		contentPane.add(p7);

		// OTTAVO PANNELLO - bordo inciso con titolo
		Border incisa2 = BorderFactory.createTitledBorder(incisa, "ottavo pannello");
		JPanel p8 = new JPanel();
		p8.setBorder(incisa2);
		contentPane.add(p8);

		// NONO PANNELLO - gran finale!!!
		Border composto = BorderFactory.createCompoundBorder(cornice, incisa); // creazione di bordo inciso infossato a
																				// cornice
		Border composto2 = BorderFactory.createTitledBorder(composto, "nono pannello"); // creazione di bordo inciso con
																						// titolo
		JPanel p9 = new JPanel();
		p9.setBorder(composto2);
		contentPane.add(p9);
	}

	public static void main(String[] args) {
		JFrame frame = new BorderFrame();
		frame.setVisible(true);
	}
}
