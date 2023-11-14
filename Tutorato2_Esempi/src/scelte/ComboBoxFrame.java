package scelte;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Questo esempio mostra come utilizzare una combobox
public class ComboBoxFrame extends JFrame implements ActionListener {
	private String[] elencoFont = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };
	private JComboBox font;
	private JLabel messaggio;

	public ComboBoxFrame() {
		setTitle("scegli un font");
		setSize(500, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		messaggio = new JLabel("Pippo, Pluto e Paperino");
		messaggio.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(messaggio, BorderLayout.CENTER);

		JPanel p = new JPanel(new BorderLayout());
		JLabel l = new JLabel("Scegli un font");
		p.add(l, BorderLayout.WEST);

		font = new JComboBox(elencoFont);
		p.add(font, BorderLayout.CENTER);
		font.addActionListener(this);

		contentPane.add(p, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		String f = (String) font.getSelectedItem();
		messaggio.setFont(new Font(f, Font.PLAIN, 24));
	}

	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame();
		frame.setVisible(true);
	}
}
