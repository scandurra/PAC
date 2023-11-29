import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CounterTest {
	@Test
	public void testNewCounter() {
		Counter c = new Counter();
		assertEquals(0, c.get());
		
		c = new Counter(7);
		assertEquals(7, c.get());
	}

	@Test
	public void testInc() {
		Counter c = new Counter();
		assertEquals(1, c.inc());
		assertEquals(2, c.inc());
		assertEquals(3, c.inc());
		
		c = new Counter(7);
		assertEquals(8, c.inc());
	}
	
	@Test
	public void testDec() {
		Counter c = new Counter();
		assertEquals(-1, c.dec());
		assertEquals(-2, c.dec());
		assertEquals(-3, c.dec());
		
		c  = new Counter(1);
		
		assertEquals(0, c.dec());
	}

}
