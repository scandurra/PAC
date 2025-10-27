package scelte;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The Class ComboBoxFrame.
 * 
 * Questo esempio mostra come utilizzare una combobox.
 */
public class ComboBoxFrame extends JFrame implements ActionListener {

	/** The elenco font. */
	private String[] elencoFont = { "Serif", "SansSerif", "Monospaced", "Dialog", "InputDialog" };

	/** The font. */
	private JComboBox<String> font;

	/** The messaggio. */
	private JLabel messaggio;

	/**
	 * Instantiates a new combo box frame.
	 */
	public ComboBoxFrame() {
		setTitle("Scegli un font");
		setSize(500, 200);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		messaggio = new JLabel("Lorem ipsum dolor sit amet");
		messaggio.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(messaggio, BorderLayout.CENTER);

		JPanel p = new JPanel(new BorderLayout());
		JLabel l = new JLabel("Scegli un font");
		p.add(l, BorderLayout.WEST);

		font = new JComboBox<String>(elencoFont);
		p.add(font, BorderLayout.CENTER);
		font.addActionListener(this);

		contentPane.add(p, BorderLayout.SOUTH);
	}

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	public void actionPerformed(ActionEvent e) {
		String f = (String) font.getSelectedItem();
		messaggio.setFont(new Font(f, Font.PLAIN, 24));
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new ComboBoxFrame();
		frame.setVisible(true);
	}
}
