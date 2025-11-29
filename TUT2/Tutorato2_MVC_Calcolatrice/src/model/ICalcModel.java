package model;

import java.util.Observable;

import view.IOperationResultDelegate;

// TODO: Auto-generated Javadoc
/**
 * The Interface ICalcModel.
 */
public interface ICalcModel {
	
	/**
	 * Reset.
	 */
	public void reset();
	
	/**
	 * Multiply by.
	 *
	 * @param operand the operand
	 */
	public void multiplyBy(String operand);
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue();
	
	
	/**
	 * Sets the delegate for Observer/Delegate pattern.
	 *
	 * @param delegate the new delegate
	 */
	void setDelegate(IOperationResultDelegate delegate);
}
