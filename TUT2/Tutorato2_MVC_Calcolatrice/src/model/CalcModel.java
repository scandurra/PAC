package model;

import java.util.Observable;
import view.IOperationResultDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Class CalcModel.
 *  Definiamo il modello come "Observable". Una classe model che estende
 *  "Observable" può essere gestita in modo molto più sempice, in quanto ogni
 *  modifica fatta al suo contenuto, genera in automatico una notifica
 *  per gli observer (questo per notificare alla view cambi di stato al interno del model stesso).
 *  
 *  La stesso meccanismo è qui implementato anche tramite pattern observer/delegate.
 */
public class CalcModel extends Observable implements ICalcModel {
	
	/** The Constant INITIAL_VALUE. */
	// Campo privato, il valore iniziale della "memoria" del modello
	private static final String INITIAL_VALUE = "1";
	
	/** The m total. */
	// Campo privato, la "memoria" vera e propria del modello
	private Integer m_total;

	/** The result delegate. */
	private IOperationResultDelegate resultDelegate = null;
	
	/**
	 * Instantiates a new calc model.
	 */
	public CalcModel() {
		reset();
	}
	
	/**
	 * Sets the delegate.
	 *
	 * @param delegate the new delegate
	 */
	public void setDelegate(IOperationResultDelegate delegate) {
		resultDelegate = delegate;
	}
	
	/**
	 * Reset.
	 */
	public void reset() {
		System.out.println("[MODEL] reset ");
		m_total = new Integer(INITIAL_VALUE);
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		// notifyObservers();
		
		if (resultDelegate != null) {
			resultDelegate.onOperationResult(m_total.toString());
		}
		System.out.println("[MODEL] Observers notified (reset)");
	}
	
	/**
	 * Multiply by.
	 * The value passed from the controller, not from the GUI.
	 *
	 * @param operand the operand
	 */
	public void multiplyBy(String operand) {
		// Moltiplicazione vera e propria
		m_total = m_total * new Integer(operand);
		System.out.println("[MODEL] Multiply " + operand);
		// Comunica un cambio dello stato
		setChanged();
		// Notifica gli observer (la view)
		// notifyObservers();
		
		if (resultDelegate != null) {
			resultDelegate.onOperationResult(m_total.toString());
		}
		
		System.out.println("[MODEL] Observers notified (mult)");
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return m_total.toString();
	}
}
