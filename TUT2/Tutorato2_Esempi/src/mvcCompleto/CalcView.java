package mvcCompleto;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

//View, NB: implementa Observer
class CalcView extends JFrame implements Observer {
	// Campi della view
	private JTextField m_userInputTf = new JTextField(5);
	private JTextField m_totalTf = new JTextField(20);
	private JButton m_multiplyBtn = new JButton("Multiply");
	private JButton m_clearBtn = new JButton("Clear");

	// Riferimento a model
	private CalcModel m_model;

	// Costruttore
	CalcView(CalcModel model) {
		// alloco il riferimento passato
		m_model = model;
		// il model implementa Observable, aggiungo al modello un osservatore (la view
		// stessa)
		m_model.addObserver(this);

		// inizio a configurare la vista
		m_totalTf.setText(model.getValue());
		m_totalTf.setEditable(false);

		// Layout dei componenti
		JPanel content = new JPanel();
		content.setLayout(new FlowLayout());
		content.add(new JLabel("Input"));
		content.add(m_userInputTf);
		content.add(m_multiplyBtn);
		content.add(new JLabel("Total"));
		content.add(m_totalTf);
		content.add(m_clearBtn);

		// Creo il contenitore...
		this.setContentPane(content);
		this.pack();
		// ...il titolo...
		this.setTitle("Simple Calc - MVC");
		// ...e il meccanismo di chiusura
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * I metodi seguenti servono a chi detiene un riferimento alla view (il
	 * controller) Se non ci fossero, il controller dovrebbe avere un riferimento
	 * esplicito a tutti gli elementi della view per poter svolgere operazioni. In
	 * questo modo, invece, � sufficiente avere il riferimento all'intera classe
	 * CalcView.
	 */
	// Getter per rendere disponibile all'esterno il valore del campo testo del
	// textField
	String getUserInput() {
		return m_userInputTf.getText();
	}

	// rende disponibile all'esterno l'eventuale testo del messaggio di errore
	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	// permette di impostare dall'esterno il listener del bottone moltiplica
	void addMultiplyListener(ActionListener mal) {
		m_multiplyBtn.addActionListener(mal);
	}

	// permette di impostare dall'esterno il listener del bottone clear
	void addClearListener(ActionListener cal) {
		m_clearBtn.addActionListener(cal);
	}

	// Ereditato da Observer, chiama il metodo update definito localmente quando
	// l'osservato (il modello)
	// effettua una notifica
	@Override
	public void update(Observable o, Object arg) {
		update();
	}

	// permette di fare l'update dall'esterno.
	// in questo caso � l'azione compiuta dalla GUI quando il model (che �
	// osservato)
	// effettua una notifica
	private void update() {
		// estraggo il valore corrente della "memoria" del modello dal
		// riferimento al modello e aggiorno il textField.
		System.out.println("[VIEW] Notified by the model");
		m_totalTf.setText(m_model.getValue());
	}

}
