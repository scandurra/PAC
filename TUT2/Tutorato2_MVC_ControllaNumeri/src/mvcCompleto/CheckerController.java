package mvcCompleto;

import java.awt.event.*;

public class CheckerController {
	// Riferimenti, il controller deve interagire sia con la view che con il modello
	private ChckerModel m_model;
	private CheckerView m_view;

	// Costruttore
	CheckerController(ChckerModel model, CheckerView view) {
		// alloco i riferimenti passati
		m_model = model;
		m_view = view;

		// Aggiungo i listener (definiti qui) alla view attraverso i metodi appositi
		// messi a disposizione della view
		view.addCheckListener(new CheckListener());
	}

	/*
	 * Definizione dei listener (Inner classes)
	 */
	// Listener per la moltiplicazione. Questa azione viene eseguita quando
	// l'utente preme il tasto di moltiplicazione
	class CheckListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("[CONTROLLER] Check action received");
			String userInput = "";
			try {
				// uso il riferimento alla view per catturare l'input
				// inserito dall'utente
				userInput = m_view.getUserInput();
				// uso il riferimento al modello per fargli eseguire la moltiplicazione
				m_model.checkNumber(userInput);
			} catch (NumberFormatException nfex) {
				m_view.showError("Bad input: '" + userInput + "'");
			}
		}
	}

}
