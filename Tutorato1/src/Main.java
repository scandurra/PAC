import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader fileReader = new BufferedReader(new FileReader(new File("input.txt")));

		Object[] nums = fileReader.lines().toArray();
		int n1 = 0;
		int n2 = 0;

		if (nums.length > 0) {
			n1 = Integer.parseInt((String)nums[0]); // First number from first line
			n2 = Integer.parseInt((String)nums[nums.length - 1]); // Second number from last line
		}
		
		System.out.println(sum(n1, n2));
	}
	
	/**
	 * Sum.
	 *
	 * @param a First number
	 * @param b Second number
	 * @return Sum of the two
	 */
	private static int sum(int a, int b) {
		return a + b;
	}

}
