package mcmullin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 03/04/2017
 * @author Cole McMullin
 *finds the greatest common factor of 2 numbers inputed by the user
 */
public class GCF {

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
		System.out.println("Please input another number.");
		int y = 0;
		try {
			y = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The GCF of " + x + " and " + y + " is " + greatestCommonFactor(x, y));
	}
/**
 *  finds the greatest common factor of 2 inputed numbers
 * @param a (an inputed integer)
 * @param b (an inputed integer)
 * @return the greatest common factor of the two numbers
 */
	public static int greatestCommonFactor(int a, int b){
		int large = Math.max(a, b);
		int small = Math.min(a, b);
		for (int i = small; i > 0; i--){
			if (isDivisible(large, i) && isDivisible(small, i)){
				return i;
			}
		}
		return 0;
	}
	/**
	 *  finds if a number is are evenly divisible by another number
	 * @param a (an inputed integer)
	 * @param b (an inputed integer)
	 * @return weather or not the first number4 is divisible by the second
	 */

	public static boolean isDivisible(int a, int b){
		if (a % b == 0){
			return true;
		}
		return false;
	}

}
