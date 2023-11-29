import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

@RunWith(Parametrized.class)
class SumTest {
  // tests the method sum(a, b) == c

  private int a;
  private int b;
  private int expectedOutput;

  public SumTest(int a, int b, int expectedOutput) {
    this.a = a;
    this.b = b;
    this.expectedOutput = expectedOutput;
  }

  @Parameters
  public static Colletion creaParams() {
    return Arrays.asList(new Object[][] {
      {0, 0, 0},
      {5, 8, 13},
      {-9, 8, -1}
    });
  }

  @Test
  public void testSum() {
    assertEquals(this.expectedOutput, sum(this.a, this.b));
  }
}
