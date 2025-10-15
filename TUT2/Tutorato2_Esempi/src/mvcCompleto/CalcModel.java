package mvcCompleto;

import java.math.BigInteger;
import java.util.Observable;

// questo � anche observable
// quando cambia, notifica gli observer

public class CalcModel extends Observable {
	// Campo privato, il valore iniziale della "memoria" del modello
	private static final String INITIAL_VALUE = "1";
	// campo privato, la "memoria" vera e propria del modello
	private BigInteger m_total;

	// Costruttore, chiama il reset per (re)impostare il valore inizale
	CalcModel() {
		reset();
	}

	// reset del valore iniziale
	public void reset() {
		System.out.println("[MODEL] reset ");
		m_total = new BigInteger(INITIAL_VALUE);
		// comuncia un cambio dello stato
		setChanged();
		// notifica gli osservatori (la view)
		notifyObservers();
		System.out.println("[MDOEL] Observers notified (reset)");
	}

	// Moltiplica per il valore passato come stringa
	// Attenzione: non dalla GUI ma dal controller
	public void multiplyBy(String operand) {
		// Moltiplicazione vera e propria
		m_total = m_total.multiply(new BigInteger(operand));
		System.out.println("[MODEL] Multiply " + operand);
		// comuncia un cambio dello stato
		setChanged();
		// notifica gli osservatori (la view)
		notifyObservers();
		System.out.println("[MDOEL] Observers notified (mult)");
	}

	// Ritorna il valore della "memoria"
	public String getValue() {
		return m_total.toString();
	}
}
