package view;

import java.awt.*;
import javax.swing.*;

import model.CalcModel;

import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

/**
 * The Class CalcView.
 * 
 * View della Calcolatrice. Implementiamo "Observer" per fare in modo di
 * controllare le modifiche sul model e venir notificati ad ogni modifica.
 */
// del model
public class CalcView extends JFrame implements Observer {
	
	/** The m user input tf. */
	// Campi della view
	private JTextField m_userInputTf = new JTextField(5);
	
	/** The m total tf. */
	private JTextField m_totalTf = new JTextField(20);
	
	/** The m multiply btn. */
	private JButton m_multiplyBtn = new JButton("Multiply");
	
	/** The m clear btn. */
	private JButton m_clearBtn = new JButton("Clear");

	/** The m model. */
	// Riferimento a model
	private CalcModel m_model;

	/**
	 * Instantiates a new calc view.
	 *
	 * @param model the model
	 */
	// Costruttore
	public CalcView(CalcModel model) {
		// Alloco il riferimento passato relativo al modello
		m_model = model;
		// Il model implementa Observable, aggiungo al modello un Observer
		// (la view stessa)
		m_model.addObserver(this);

		// Inizio a configurare la vista
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
		// Imposto il titolo alla view
		this.setTitle("Simple Calc - MVC");
		// Imposto il meccanismo di chiusura sulla finestra
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * I metodi seguenti servono a chi detiene un riferimento alla view (il
	 * controller) Se non ci fossero, il controller dovrebbe avere un riferimento
	 * esplicito a tutti gli elementi della view per poter svolgere operazioni. In
	 * questo modo, invece, è sufficiente avere il riferimento all'intera classe
	 * CalcView.
	 */
	// Getter per rendere disponibile all'esterno il valore del campo
	/**
	 * Gets the user input.
	 *
	 * @return the user input
	 */
	// testo del textField
	public String getUserInput() {
		return m_userInputTf.getText();
	}

	/**
	 * Show error.
	 *
	 * @param errMessage the err message
	 */
	// Rende disponibile all'esterno l'eventuale testo del messaggio di errore
	public void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	/**
	 * Adds the multiply listener.
	 *
	 * @param mal the mal
	 */
	// Permette di impostare dall'esterno il listener del bottone moltiplica
	public void addMultiplyListener(ActionListener mal) {
		m_multiplyBtn.addActionListener(mal);
	}

	/**
	 * Adds the clear listener.
	 *
	 * @param cal the cal
	 */
	// Permette di impostare dall'esterno il listener del bottone clear
	public void addClearListener(ActionListener cal) {
		m_clearBtn.addActionListener(cal);
	}

	// Ereditato da Observer, chiama il metodo update definito localmente
	/**
	 * Update.
	 *
	 * @param o the o
	 * @param arg the arg
	 */
	// quando l'osservato (il modello) effettua una notifica
	@Override
	public void update(Observable o, Object arg) {
		update();
	}

	// Permette di fare l'update dall'esterno.
	// In questo caso è l'azione compiuta dalla GUI quando il model
	/**
	 * Update.
	 */
	// (che è stato impostato come Observable) effettua una notifica
	private void update() {
		// Estraggo il valore corrente della "memoria" del modello dal
		// riferimento al modello e aggiorno il textField.
		System.out.println("[VIEW] Notified by the model");
		m_totalTf.setText(m_model.getValue());
	}

}
