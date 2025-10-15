package mvcCompleto;

public class CalcMVC {
	// Main
	public static void main(String[] args) {
		// Creo il model
		CalcModel model = new CalcModel();
		// Creo la view passando il rif al model
		CalcView view = new CalcView(model);
		// Creo il controller passando il rif al model e alla view
		CalcController controller = new CalcController(model, view);
		// Rendo visibile la view
		view.setVisible(true);
	}
}
