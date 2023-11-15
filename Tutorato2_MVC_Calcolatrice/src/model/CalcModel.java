package model;

import java.util.Observable;

/*
 *  Definiamo il modello come "Observable". Una classe model che estende
 *  "Observable" può essere gestita in modo molto più sempice, in quanto ogni
 *  modifica fatta al suo contenuto, genera in automatico una notifica
 *  per gli observer
 */
public class CalcModel extends Observable{
	// Campo privato, il valore iniziale della "memoria" del modello
	private static final String INITIAL_VALUE = "1";
	// Campo privato, la "memoria" vera e propria del modello 
	private Integer m_total; 

	// Costruttore: chiama il reset per (re)impostare il valore inizale
	public CalcModel() {
		reset();
	}

	// Reset del valore iniziale
	public void reset() {
		System.out.println("[MODEL] reset ");
		m_total = new Integer(INITIAL_VALUE);
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		notifyObservers();
		System.out.println("[MODEL] Observers notified (reset)");
	}


	// Moltiplica per il valore passato come stringa 
	// Attenzione: non dalla GUI ma dal controller
	public void multiplyBy(String operand) {
		// Moltiplicazione vera e propria
		m_total = m_total * new Integer(operand);
		System.out.println("[MODEL] Multiply "+ operand);
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		notifyObservers();
		System.out.println("[MODEL] Observers notified (mult)");
	}

	// Ritorna il valore della "memoria"
	public String getValue() {
		return m_total.toString();
	}
}
