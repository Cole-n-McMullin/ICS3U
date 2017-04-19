/**
 * 
 */
package mcmullin;

/**
 * @author Cole McMullin
 * 4/19/2017
 * prints all numbers less than 100 that are the sum of all their factors 
 */
public class PerfectNumbers {

	public static void main(String[] args) {
		for(int i = 1; i < 1000; i++){
			if(isPerfectNumber(i)){
				System.out.println(i);
			}
		}

	}
	/**
	 * returns whether or not the sum of all the factors of the inputed number equal the inputed number
	 * @param x a number
	 * @return whether or not the sum of all the factors of the inputed number equal the inputed number
	 */
	public static boolean isPerfectNumber(int x){
		int total = 0;
		for(int i = 1; i < x; i++){
			if (isDivisible(x, i)){
				total += i;
			}
		}
		if(total == x){
			return true;
		}
		return false;
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
