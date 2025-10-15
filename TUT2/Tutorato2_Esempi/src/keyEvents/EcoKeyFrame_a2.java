package keyEvents;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//Questo esempio mostra come un Frame registra gli eventi della tastiera.
//L'output viene inviato ad un pannello e costantemente aggiornato
//il frame � anche il key listener, pertanto si autoregistrer�
public class EcoKeyFrame_a2 extends JFrame implements KeyListener {
	private EcoKeyPanel_a2 pannello;

	public EcoKeyFrame_a2() {
		setTitle("frame per vedere gli eventi tastiera");
		setSize(800, 500);
		setLocation(100, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Autoregistrazione come keyListener
		addKeyListener(this);

		// Creo un container per il pannello
		Container contentPane = getContentPane();
		// creo il pannello
		pannello = new EcoKeyPanel_a2();
		// lo aggiungo al container
		contentPane.add(pannello);
	}

	// in generale i seguenti metodi impostano dei campi del pannello grafico
	// che il metodo paint() del pannello usa per conoscere cosa disegnare/scriver
	// Notare che al termine di ogni metodo viene chiamato il repaint del pannello
	// per visualizzare le modifiche
	public void keyPressed(KeyEvent k) {
		// Recupero il codice del tasto premuto
		int codiceTasto = k.getKeyCode();

		pannello.mPressed1 = "premuto il tasto " + codiceTasto;

		// Recupero la descrizione del tasto premuto
		pannello.mPressed2 = "tale codice corrisponde al tasto virtuale \"VK_" + k.getKeyText(codiceTasto) + "\"";

		pannello.mReleased1 = "";
		pannello.mReleased2 = "";
		pannello.mTyped = "";
		pannello.repaint();
	}

	public void keyReleased(KeyEvent k) {
		// Recupero il codice del tasto rilasciato
		int codiceTasto = k.getKeyCode();

		pannello.mPressed1 = "";
		pannello.mPressed2 = "";
		pannello.mReleased1 = "rilasciato il tasto " + codiceTasto;

		// Recupero la descrizione del tasto rilasciato
		pannello.mReleased2 = "tale codice corrisponde al tasto virtuale \"VK_" + k.getKeyText(codiceTasto) + "\"";

		pannello.mTyped = "";
		pannello.repaint();
	}

	public void keyTyped(KeyEvent k) {
		// Recupero la descrizione del tasto digitato
		pannello.mTyped = "completata la digitazione del carattere \'" + k.getKeyChar() + "\'";

		pannello.repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new EcoKeyFrame_a2();
		frame.setVisible(true);
	}
}

class EcoKeyPanel_a2 extends JPanel {
	private static final long serialVersionUID = 1L;

	public String mPressed1 = "", mPressed2 = "";
	public String mReleased1 = "", mReleased2 = "";
	public String mTyped = "";

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.white);
		g.setFont(new Font("Monospaced", Font.BOLD, 18));
		g.drawString("Eventi della tastiera", 50, 30);
		g.drawString("schiaccia tasti e vedi l'effetto", 50, 90);
		g.drawString(mPressed1, 50, 130);
		g.drawString(mPressed2, 50, 160);
		g.drawString(mReleased1, 50, 200);
		g.drawString(mReleased2, 50, 245);
		g.drawString(mTyped, 50, 280);
	}
}
