package scelte;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

//Questo esempio mostra come utilizzare una lista
//Implemento il ListSelectionListener per gestire gli eventi sulla lista
public class ListFrame_a1 extends JFrame implements ListSelectionListener {
	private String[] elencoFont = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };
	private JList font;
	private JLabel messaggio;

	public ListFrame_a1() {
		// Imposto il JFramerame
		setTitle("scegli un font");
		setSize(500, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Container
		Container contentPane = getContentPane();

		// Creo una JLabel per il messaggio
		messaggio = new JLabel("Pippo, Pluto e Paperino");
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
		font = new JList(elencoFont);
		// Imposto la modalit� di selezione singola
		font.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// aggiungo il listener
		font.addListSelectionListener(this);
		// aggiungo al panel il pannello a scorrimento che contiene la JList al centro
		p.add(new JScrollPane(font), BorderLayout.CENTER);

		// aggiungo il JPanel al container
		contentPane.add(p, BorderLayout.CENTER);
	}

	// Gestione evento su lista
	public void valueChanged(ListSelectionEvent e) {
		// Ottengo la entry selezionata
		String f = (String) font.getSelectedValue();
		// Imposto il carattere in base alla stringa recuperata dalla entry selezionata
		messaggio.setFont(new Font(f, Font.PLAIN, 24));
	}

	public static void main(String[] args) {
		JFrame frame = new ListFrame_a1();
		frame.setVisible(true);
	}
}
