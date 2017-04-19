package mcmullin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * SumDigits.java
 * 03/04/2017
 * @author Cole McMullin
 *finds the sum of the digits of a number inputed by the user
 */
public class SumDigits {

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
		System.out.println("The sum of the digits of " + x + " is " + sumDigits(x));
		
	}
	/**
	 * finds the sum of the digits of an inputed number 
	 * @param a (an inputed integer)
	 * @return the sum of the digits
	 */
	public static int sumDigits(int a){
		int total = 0;
		while(a > 0){
			total += a % 10;
			a = a / 10;
		}
		return total;
	}

}
