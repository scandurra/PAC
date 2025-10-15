package mvcSemplice;

public class CalcModel {
	// Campo privato, la "memoria" del modello
	private double value;

	public CalcModel() {
		System.out.println("[MODEL] Created");
		value = 1;
	}

	public void clear() {
		value = 1;
		System.out.println("[MODEL] reset value");
	}

	public void multiply(double d) {
		value *= d;
		System.out.println("[MODEL] mutliplying value " + d);
	}

	public double getValue() {
		return value;
	}
}
