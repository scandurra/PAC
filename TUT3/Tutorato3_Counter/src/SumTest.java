import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
class Sum {
	public static int sum(int a, int b) {
		return a + b;
	}
}

class SumTest {
	// tests the method sum(a, b) == c

	private int a;
	private int b;
	private int expectedOutput;

	@Parameters
	public static Collection<Object[]> creaParams() {
		return Arrays.asList(new Object[][] {
			{0, 0, 0},
			{5, 8, 13},
			{-9, 8, -1}
		});
	}

	@Test
	public void testSum() {
		assertEquals(this.expectedOutput, Sum.sum(this.a, this.b));
	}
}
