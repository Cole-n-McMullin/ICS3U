package mcmullin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 03/04/2017
 * @author Cole McMullin
 *finds the factorial of a number inputed by the user
 */
public class Factorial {
	
	static BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		System.out.println("Please input a number.");
		int x = 0;
		try {
			x = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(x + " factorial is " + factorial(x));
		
	}
	/**
	 * finds the factorial of the inputed number
	 * @param an inputed integer
	 * @return the factorial of the inputed number
	 */
	public static int factorial( int a){
		int total = 1;
		if (a < 1){
			return -1;
		}
		for (int i = a; i > 1; i--){
			total = total * i;
		}
		return total;
	}

}
