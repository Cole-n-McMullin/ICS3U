package mcmullin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 03/04/2017
 * @author Cole McMullin
 *finds the out if a number inputed by the user, is prime
 */
public class Prime {

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
		if (isPrime(x)){
			System.out.println(x + " is prime");
		}
		else{
			System.out.println(x + " is not prime");
		}
	}
/**
 * finds the out if a number is prime
 * @param a (an inputed integer)
 * @return weather or not the number is prime
 */
	public static boolean isPrime(int a){
		if(a<1){
			return false;
		}
		else{
			for (int i = a/2; i > 1; i--){
				if (isDivisible(a, i)){
					return false;
				}
			}
			return true;
		}
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
