package layout;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.EventListener;

/**
 * The Class LayoutAbsoluteFrame.
 * 
 * Questo esempio mostra un AbsoluteLayout all'opera.
 */
public class LayoutAbsoluteFrame extends JFrame {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new layout absolute frame.
	 */
	public LayoutAbsoluteFrame() {
		setTitle("AbsoluteLayout all'opera");
		// imposto misure e posizionamento
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Creo il container
		Container pane = getContentPane();
		// Imposto il layout nullo, in questo modo richiamo il
		// layout di default che è l'absolute
		pane.setLayout(null);

		// Creo i bottoni e...
		JButton b1 = new JButton("one");
		JButton b2 = new JButton("two");
		JButton b3 = new JButton("three");
		// ... li aggiungo
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);

		// L'oggetto Insets restituisce le misure del container
		// in questo caso il panel. Lo posso usare per posizionare gli oggetti in modo
		// che vengano "ancorati" ad una delle dimensioni del panel
		Insets insets = getInsets();
		// mi faccio restituire le dimensioni di default di un bottone
		Dimension size = b1.getPreferredSize();
		// imposto posizione e dimensione dei bottoni.
		b1.setBounds(25 + insets.left, 5 + insets.top, size.width, size.height);
		size = b2.getPreferredSize();
		b2.setBounds(55 + insets.left, 40 + insets.top, size.width, size.height);
		size = b3.getPreferredSize();
		b3.setBounds(150 + insets.left, 15 + insets.top, size.width + 50, size.height + 20);

	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new LayoutAbsoluteFrame();
		frame.setVisible(true);
	}
}
