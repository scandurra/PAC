import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoinboxTest {

	@Test
	void testInit() {
		Coinbox c = new Coinbox();
		assertEquals(0, c.getNMonete());
	}

	@Test
	void testSingleVend() {
		Coinbox c = new Coinbox();
		c.insertCoin();
		c.insertCoin();
		assertTrue(c.erogaProdotto());
	}

	@Test
	void testNotEnough() {
		Coinbox c = new Coinbox();
		c.insertCoin();
		assertFalse(c.erogaProdotto());
	}

}
