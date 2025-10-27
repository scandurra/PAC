package menu;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The Class MenuFrame.
 * 
 * Questo esempio mostra come utilizzare i menu.
 */
public class MenuFrame extends JFrame implements ActionListener, MouseListener {

	/** The pannello fiore. */
	private MenuPanel pannelloFiore;

	/** The colori str. */
	private String[] coloriStr = { "Rosso", "Verde", "Blu", "Giallo", "Arancio", "Rosa" };

	/** The mnemonic. */
	private char[] mnemonic = { 'r', 'v', 'b', 'g', 'a', 'o' };

	/** The colori. */
	private Color[] colori = { Color.red, Color.green, Color.blue, Color.yellow, Color.orange, Color.pink };

	/** The sfondo. */
	private JMenuItem[] sfondo = new JMenuItem[colori.length];

	/** The petalo. */
	private JMenuItem[] petalo = new JMenuItem[colori.length];

	/** The cuore. */
	private JMenuItem[] cuore = new JMenuItem[colori.length];

	/** The popup item. */
	private JMenuItem[] popupItem = new JMenuItem[colori.length];

	/** The popup. */
	private JPopupMenu popup;

	/** The type. */
	private int type = -1;

	/** The Constant MENU_MASK. */
	final static int MENU_MASK = Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();

	/**
	 * Instantiates a new menu frame.
	 */
	@SuppressWarnings("deprecation")
	public MenuFrame() {
		setTitle("fiore di primavera");
		setSize(300, 400);
		setLocation(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		pannelloFiore = new MenuPanel();
		pannelloFiore.addMouseListener(this);
		contentPane.add(pannelloFiore);

		// Creo la barra del menu
		JMenuBar barraMenu = new JMenuBar();

		// Creo il menu sfondo ed i suoi item
		JMenu coloriSfondo = new JMenu("Sfondo");
		coloriSfondo.setMnemonic('S');
		for (int i = 0; i < colori.length; i++) {
			sfondo[i] = new JMenuItem(coloriStr[i]);
			sfondo[i].setMnemonic(mnemonic[i]);
			sfondo[i].setAccelerator(KeyStroke.getKeyStroke(new Character(mnemonic[i]), MENU_MASK));
			sfondo[i].addActionListener(this);
			coloriSfondo.add(sfondo[i]);
		}
		// Aggiungo
		barraMenu.add(coloriSfondo);

		// Creo il menu petali ed i suoi item
		JMenu coloriPetalo = new JMenu("Petali");
		coloriPetalo.setMnemonic('P');
		for (int i = 0; i < colori.length; i++) {
			petalo[i] = new JMenuItem(coloriStr[i]);
			petalo[i].setMnemonic(mnemonic[i]);
			petalo[i].addActionListener(this);
			coloriPetalo.add(petalo[i]);
		}
		// Aggiungo
		barraMenu.add(coloriPetalo);

		// Creo il menu cuore ed i suoi item
		JMenu coloriCuore = new JMenu("Cuore");
		coloriCuore.setMnemonic('C');
		for (int i = 0; i < colori.length; i++) {
			cuore[i] = new JMenuItem(coloriStr[i]);
			cuore[i].setMnemonic(mnemonic[i]);
			cuore[i].addActionListener(this);
			coloriCuore.add(cuore[i]);
		}
		// Aggiungo
		barraMenu.add(coloriCuore);

		// Creo il menu cuore ed i suoi item di tipo popup (da usare con il mouse)
		popup = new JPopupMenu();
		for (int i = 0; i < colori.length; i++) {
			popupItem[i] = new JMenuItem(coloriStr[i]);
			popupItem[i].setMnemonic(mnemonic[i]);
			popupItem[i].addActionListener(this);
			popup.add(popupItem[i]);
		}

		// Aggiungo la barra al frame
		setJMenuBar(barraMenu);
	}

	/**
	 * Action performed.
	 *
	 * Gestore di eventi sul menu
	 *
	 * @param e the e
	 */
	public void actionPerformed(ActionEvent e) {
		// Individuo la sorgente dell'evento
		Object source = e.getSource();
		for (int i = 0; i < colori.length; i++) {
			if (source == sfondo[i])
				pannelloFiore.setSfondo(colori[i]);
			else if (source == petalo[i])
				pannelloFiore.setPetali(colori[i]);
			else if (source == cuore[i])
				pannelloFiore.setCuore(colori[i]);
			else if (source == popupItem[i]) {

				switch (type) { // Coloro in base al tipo del menu di provenienza dell'elenco
				case MenuPanel.CUORE:
					pannelloFiore.setCuore(colori[i]);
					break;
				case MenuPanel.PETALO:
					pannelloFiore.setPetali(colori[i]);
					break;
				case MenuPanel.SFONDO:
					pannelloFiore.setSfondo(colori[i]);
					break;
				}
			}
		}
	}

	/**
	 * Mouse clicked.
	 *
	 * @param e the e
	 */
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Mouse entered.
	 *
	 * @param e the e
	 */
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Mouse exited.
	 *
	 * @param e the e
	 */
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Mouse pressed.
	 *
	 * @param e the e
	 */
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Mouse released.
	 *
	 * @param e the e
	 */
	public void mouseReleased(MouseEvent e) {

		// Solo se tasto destro
		if (e.getButton() == 3) {
			Point p = e.getPoint();
			type = pannelloFiore.getType(p);
			popup.show(pannelloFiore, p.x, p.y);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		MenuFrame frame = new MenuFrame();
		frame.setVisible(true);
	}
}

class MenuPanel extends JPanel {
	public final static int CUORE = 0;
	public final static int PETALO = 1;
	public final static int SFONDO = 2;

	private Color sfondo, petali, cuore;

	// Questi oggetti saranno introdotti nelle prossime lezioni
	private Ellipse2D cuoreShape;
	private Area petaliShape = new Area();

	public MenuPanel() {
		sfondo = new Color(100, 100, 100);
		petali = new Color(200, 200, 200);
		cuore = new Color(50, 50, 50);
	}

	public int getType(Point p) {
		// Verifico dove e' contenuto il punto
		if (cuoreShape.contains(p))
			return this.CUORE;
		else if (petaliShape.contains(p))
			return this.PETALO;
		else
			return this.SFONDO;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		setBackground(sfondo);
		Dimension d = getSize();
		int raggioFiore = ((d.width > d.height) ? d.height : d.width) / 4;
		int raggioPetalo = raggioFiore / 2;

		g.setColor(petali);
		// Creo la forma dei petali
		for (int i = 0; i < 8; i++) {
			double angolo = 2 * Math.PI / 8 * i;
			petaliShape.add(new Area(new Ellipse2D.Double(d.width / 2 + raggioFiore * Math.cos(angolo) - raggioPetalo,
					d.height / 2 + raggioFiore * Math.sin(angolo) - raggioPetalo, 2 * raggioPetalo, 2 * raggioPetalo)));
		}
		g2.fill(petaliShape);

		g.setColor(cuore);
		// Creo la forma del cuore
		cuoreShape = new Ellipse2D.Double(d.width / 2 - raggioFiore, d.height / 2 - raggioFiore, 2 * raggioFiore,
				2 * raggioFiore);
		g2.fill(cuoreShape);
	}

	public void setSfondo(Color c) {
		sfondo = c;
		repaint();
	}

	public void setPetali(Color c) {
		petali = c;
		repaint();
	}

	public void setCuore(Color c) {
		cuore = c;
		repaint();
	}
}