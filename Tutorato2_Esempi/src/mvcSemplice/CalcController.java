package mvcSemplice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {

	CalcModel model;
	CalcView view;

	public CalcController(CalcModel m, CalcView v) {
		// prede i riferimenti
		model = m;
		view = v;
		registerController();
	}

	private void registerController() {
		// si registra al bottone reset
		// Listener anonimo
		view.btnReset.addActionListener(new ActionListener() {
			// Ridefinizione del metodo dell'action listener
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("[CONTROLLER] Clear action received");
				// uso il riferimento al modello per fargli fare il reset
				model.clear();
				// uso il riferimento alla view per fargli fare un update
				view.updateView();
			}
		});

		// Si registra al bottone multiply
		// Listener anonimo
		view.btnMultiply.addActionListener(new ActionListener() {
			// Ridefinizione del metodo
			public void actionPerformed(ActionEvent e) {
				System.out.println("[CONTROLLER] Multiply action received");
				try {
					double d = Double.parseDouble(view.input.getText());
					// Uso il riferimento al modello per fargli fare un reset
					model.multiply(d);
					// Uso il riferimento alla view per fargli fare un update
					view.updateView();
				} catch (Exception ex) {
				}
			}
		});
	}

}
