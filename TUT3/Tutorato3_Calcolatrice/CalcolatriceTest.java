import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class CalcolatriceTest {
	@Test
	public void test() {
		assertEquals(8, Calcolatrice.pow(2, 3));
		assertDoesNotThrow(() -> { Calcolatrice.pow(2, 3); });
	}
}
