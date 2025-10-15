package closableFrame;

import javax.swing.*;
import java.awt.event.*;

//Secondo sistema per chiudere l'applicazione al chiudersi del Frame
//tramite i listener
public class CloseableFrame extends JFrame {
	public CloseableFrame() {
		// Imposto un titolo per il Frame
		setTitle("Un secondo frame che non fa nulla, ma si chiude...");
		// Imposto una dimensione per il frame
		setSize(500, 200);
		// Posiziono il frame un qualche punto dello schermo
		setLocation(300, 100);
		// Visualizzo il frame sullo schermo
		setVisible(true);
	}
}
