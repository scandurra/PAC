import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 */
public class Main {
	
    /**
     * Default constructor for Main class.
     */
    public Main() {
        // Constructor body (can be empty)
    }
    
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(new File("input.txt")));
			Object[] nums = fileReader.lines().toArray();
			int n1 = 0;
			int n2 = 0;

			if (nums.length > 0) {
				n1 = Integer.parseInt((String)nums[0]); // First number from first line
				n2 = Integer.parseInt((String)nums[nums.length - 1]); // Second number from last line
			}
			
			System.out.println("Sum is: " + sum(n1, n2));
			
		    // Use the fileReader
		} catch(IOException e) {
		    e.printStackTrace();
		} finally {
		    if (fileReader != null) {
		        try {
		            fileReader.close();
		        } catch(IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
	
	/**
	 * Sum.
	 *
	 * @param a the a
	 * @param b the b
	 * @return the Sum
	 */
	private static int sum(int a, int b) {
		return a + b;
	}
}
