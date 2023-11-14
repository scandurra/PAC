package scelte;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

//Questo esempio mostra come "personalizzare" una lista
//Implemento due listener, uno per le azioni sulla lista e uno per le azioni sul JCheclBox
public class ListFrame_b1 extends JFrame implements ActionListener, ListSelectionListener {

	// Campi privati
	private String[] elencoFont = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };
	private JList font;
	private OrderedListModel model;
	private JLabel messaggio;
	private JCheckBox ordered;

	public ListFrame_b1() {
		// Imposto il JFrame
		setTitle("scegli un font");
		setSize(500, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		// Imposto e aggiungo una JLabel con il testo
		messaggio = new JLabel("Pippo, Pluto e Paperino");
		messaggio.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(messaggio, BorderLayout.NORTH);

		// Imposto un JPanel che conterr� la lista di scelta
		JPanel p = new JPanel(new BorderLayout());
		JLabel l = new JLabel("Scegli un font");
		p.add(l, BorderLayout.WEST);

		// Elenco di font in una JList
		font = new JList(elencoFont);
		// Creo il model (personalizzato)
		model = new OrderedListModel();
		// Imposto il model nella lista
		font.setModel(model);
		// Creo il renderer della lista (personalizzato)
		ListCellRenderer renderer = new FontDefaultListCellRenderer();
		// Imposto il renderer della lista
		font.setCellRenderer(renderer);

		// Imposto la selezione singola
		font.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Imposto il listener
		font.addListSelectionListener(this);
		// aggiungo la lista cos� conigurata al Panel
		p.add(new JScrollPane(font), BorderLayout.CENTER);

		// Imposto un JCheckBox
		ordered = new JCheckBox("Ordinato");
		// Il listener
		ordered.addActionListener(this);
		// E lo aggiung ad est del panel
		p.add(ordered, BorderLayout.EAST);

		// Infine aggiungo il panel al container
		contentPane.add(p, BorderLayout.CENTER);
	}

	// Gestione evento del CheckBox
	public void actionPerformed(ActionEvent e) {
		// azione sul model della lista
		model.setOrdered(ordered.isSelected());
		font.repaint();
	}

	// Gestione evento sulla lista
	public void valueChanged(ListSelectionEvent e) {
		String f = (String) font.getSelectedValue();
		messaggio.setFont(new Font(f, Font.PLAIN, 24));
	}

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
