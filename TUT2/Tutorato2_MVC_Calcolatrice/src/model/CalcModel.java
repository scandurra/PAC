package model;

import java.util.Observable;

/**
 * The Class CalcModel.
 *  Definiamo il modello come "Observable". Una classe model che estende
 *  "Observable" può essere gestita in modo molto più sempice, in quanto ogni
 *  modifica fatta al suo contenuto, genera in automatico una notifica
 *  per gli observer (questo per notificare alla view cambi di stato al interno del model stesso).
 */
public class CalcModel extends Observable {
	
	/** The Constant INITIAL_VALUE. */
	// Campo privato, il valore iniziale della "memoria" del modello
	private static final String INITIAL_VALUE = "1";
	
	/** The m total. */
	// Campo privato, la "memoria" vera e propria del modello
	private Integer m_total;

	/**
	 * Instantiates a new calc model.
	 */
	// Costruttore: chiama il reset per (re)impostare il valore inizale
	public CalcModel() {
		reset();
	}

	/**
	 * Reset.
	 */
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
	/**
	 * Multiply by.
	 *
	 * @param operand the operand
	 */
	// Attenzione: non dalla GUI ma dal controller
	public void multiplyBy(String operand) {
		// Moltiplicazione vera e propria
		m_total = m_total * new Integer(operand);
		System.out.println("[MODEL] Multiply " + operand);
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		notifyObservers();
		System.out.println("[MODEL] Observers notified (mult)");
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	// Ritorna il valore della "memoria"
	public String getValue() {
		return m_total.toString();
	}
}
