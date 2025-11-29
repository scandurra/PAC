package mvcCompleto;

public class CheckerMVC {
	// Main
	public static void main(String[] args) {
		// Creo il model
		ChckerModel model = new ChckerModel();
		// Creo la view passando il rif al model
		CheckerView view = new CheckerView(model);
		// Creo il controller passando il rif al model e alla view
		CheckerController controller = new CheckerController(model, view);
		// Rendo visibile la view
		view.setVisible(true);
	}
}
