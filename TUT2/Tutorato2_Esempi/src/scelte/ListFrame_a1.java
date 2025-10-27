package scelte;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * The Class ListFrame_a1.
 * 
 * Questo esempio mostra come utilizzare una lista.
 * Implemento il ListSelectionListener per gestire gli eventi sulla lista.
 */
public class ListFrame_a1 extends JFrame implements ListSelectionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The elenco font. */
	private String[] elencoFont = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };

	/** The fonts. */
	private JList<String> fonts;

	/** The messaggio. */
	private JLabel messaggio;

	/**
	 * Instantiates a new list frame a 1.
	 */
	public ListFrame_a1() {
		// Imposto il JFramerame
		setTitle("Scegli un font");
		setSize(500, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Container
		Container contentPane = getContentPane();

		// Creo una JLabel per il messaggio
		messaggio = new JLabel("Lorem ipsum dolor sit amet");
		// Imposto il font iniziale
		messaggio.setFont(new Font("Serif", Font.PLAIN, 24));
		// lo aggiungo al container
		contentPane.add(messaggio, BorderLayout.NORTH);

		// Creo un JPanel con un BorderLayout
		JPanel p = new JPanel(new BorderLayout());
		// Creo una JLabel e la aggiungo al panel
		JLabel l = new JLabel("Scegli un font ");
		p.add(l, BorderLayout.WEST);

		// Creo una JList
		fonts = new JList(elencoFont);
		// Imposto la modalit� di selezione singola
		fonts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// aggiungo il listener
		fonts.addListSelectionListener(this);
		// aggiungo al panel il pannello a scorrimento che contiene la JList al centro
		p.add(new JScrollPane(fonts), BorderLayout.CENTER);

		// aggiungo il JPanel al container
		contentPane.add(p, BorderLayout.CENTER);
	}

	/**
	 * Value changed.
	 *
	 * @param e the e
	 */
	// Gestione evento su lista
	public void valueChanged(ListSelectionEvent e) {
		// Ottengo la entry selezionata
		String f = (String) fonts.getSelectedValue();
		// Imposto il carattere in base alla stringa recuperata dalla entry selezionata
		messaggio.setFont(new Font(f, Font.PLAIN, 24));
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new ListFrame_a1();
		frame.setVisible(true);
	}
}
