import static org.junit.Assert.*;
import org.junit.Test;

public class CoinboxTest {
	@Test
	public void testInit() {
		Coinbox c = new Coinbox();
		assertEquals(0, c.getNMonete());
	}

	@Test
	public void testSingleVend() {
		Coinbox c = new Coinbox();
		c.insertCoin();
		c.insertCoin();
		assertTrue(c.erogaProdotto());
	}

	@Test
	public void testNotEnough() {
		Coinbox c = new Coinbox();
		c.insertCoin();
		assertFalse(c.erogaProdotto());
	}

}
