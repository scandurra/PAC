public class Coinbox {
	int nMonete;

	public Coinbox() {
		nMonete = 0;
	}

	public int getNMonete() {
		return nMonete;
	}

	public void insertCoin() {
		nMonete++;
	}

	public boolean erogaProdotto() {
		if (nMonete >= 2) {
			nMonete -= 2;
			return true;
		}

		return false;
	}
}
