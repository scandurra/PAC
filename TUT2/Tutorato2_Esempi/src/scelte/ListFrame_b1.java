package scelte;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * The Class ListFrame_b1.
 * 
 * Questo esempio mostra come "personalizzare" una lista.
 * Implemento due listener, uno per le azioni sulla lista e uno per le azioni sul JCheclBox.
 */
public class ListFrame_b1 extends JFrame implements ActionListener, ListSelectionListener {

	/** The elenco font. */
	// Campi privati
	private String[] elencoFont = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };

	/** The font. */
	private JList<String> fonts;

	/** The model. */
	private OrderedListModel model;

	/** The messaggio. */
	private JLabel messaggio;

	/** The ordered. */
	private JCheckBox ordered;

	/**
	 * Instantiates a new list frame b 1.
	 */
	public ListFrame_b1() {
		// Imposto il JFrame
		setTitle("Scegli un font");
		setSize(500, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		// Imposto e aggiungo una JLabel con il testo
		messaggio = new JLabel("Lorem ipsum dolor sit amet");
		messaggio.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(messaggio, BorderLayout.NORTH);

		// Imposto un JPanel che conterrà la lista di scelta
		JPanel p = new JPanel(new BorderLayout());
		JLabel l = new JLabel("Scegli un font");
		p.add(l, BorderLayout.WEST);

		// Elenco di font in una JList
		fonts = new JList(elencoFont);
		// Creo il model (personalizzato)
		model = new OrderedListModel();
		// Imposto il model nella lista
		fonts.setModel(model);
		// Creo il renderer della lista (personalizzato)
		ListCellRenderer renderer = new FontDefaultListCellRenderer();
		// Imposto il renderer della lista
		fonts.setCellRenderer(renderer);

		// Imposto la selezione singola
		fonts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Imposto il listener
		fonts.addListSelectionListener(this);
		// aggiungo la lista così conigurata al Panel
		p.add(new JScrollPane(fonts), BorderLayout.CENTER);

		// Imposto un JCheckBox
		ordered = new JCheckBox("Ordinato");
		// Il listener
		ordered.addActionListener(this);
		// E lo aggiung ad est del panel
		p.add(ordered, BorderLayout.EAST);

		// Infine aggiungo il panel al container
		contentPane.add(p, BorderLayout.CENTER);
	}

	/**
	 * Action performed.
	 * 
	 * Gestione evento del CheckBox.
	 *
	 * @param e the e
	 */
	public void actionPerformed(ActionEvent e) {
		// azione sul model della lista
		model.setOrdered(ordered.isSelected());
		fonts.repaint();
	}

	/**
	 * Value changed.
	 * 
	 * Gestione evento sulla lista.
	 *
	 * @param e the e
	 */
	public void valueChanged(ListSelectionEvent e) {
		String f = (String) fonts.getSelectedValue();
		messaggio.setFont(new Font(f, Font.PLAIN, 24));
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new ListFrame_b1();
		frame.setVisible(true);
	}
}

// Scrivo un modello di lista personalizzato che permette
// di ordinare facilmente la lista (manteniamo due elenchi)
class OrderedListModel extends AbstractListModel {
	private String[] elencoFont = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };
	private String[] elencoFontOrdinato = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };
	private boolean ordered;

	public OrderedListModel() {
		Arrays.sort(elencoFontOrdinato);
	}

	// Metodo custom per ordinare la lista
	public void setOrdered(boolean b) {
		ordered = b;
	}

	// Bisogna implementare i seguenti metodi (ereditati dall'interfaccia ma non
	// implementati dalla classe astratta che
	// stiamo estendendo
	public Object getElementAt(int index) {
		if (ordered)
			return elencoFontOrdinato[index];
		else
			return elencoFont[index];
	}

	public int getSize() {
		return 5;
	}
}

// Scrivo un renderer di lista personalizzato che permette
// di vedere in anteprima il font
// se selezionato mette anche in bold
class FontDefaultListCellRenderer extends DefaultListCellRenderer {

	// Bisogna ridefinire il seguente metodo
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {

		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		String f = (String) list.getModel().getElementAt(index);
		// se � selezionato imposta BOLD, altrmenti PLAIN
		int style = isSelected ? Font.BOLD : Font.PLAIN;
		// imposta il font per fare l'anteprima
		c.setFont(new Font(f, style, 16));

		return c;
	}
}
