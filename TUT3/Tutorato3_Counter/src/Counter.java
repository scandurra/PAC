public class Counter {
  private int n;

  public Counter() {
    n = 0;
  }
  
  public Counter(int start) {
	  this.n = start;
  }

  public int inc() {
    this.n += 1;
    return this.n;
  }

  public int dec() {
    this.n -= 1;
    return this.n;
  }
  
  public int get() {
	  return this.n;
  }
}
