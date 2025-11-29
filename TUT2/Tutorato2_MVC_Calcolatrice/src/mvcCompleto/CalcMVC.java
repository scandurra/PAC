package mvcCompleto;

import controller.CalcController;
import model.CalcModel;
import model.ICalcModel;
import view.CalcView;

// TODO: Auto-generated Javadoc
/**
 * The Class CalcMVC.
 */
public class CalcMVC {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	// Main
	public static void main(String[] args) {
		// Creo il model
		ICalcModel model = new CalcModel();
		
		// Creo la view passando il rif al model
		CalcView view = new CalcView(model);
		
		model.setDelegate(view);
		
		// Creo il controller passando il rif al model e alla view
		CalcController controller = new CalcController(model, view);
		
		// Rendo visibile la view
		view.setVisible(true);
	}
}
