package mcmullin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 03/04/2017
 * @author Cole McMullin
 *finds the largest of a series of numbers inputed by the user
 */
public class LargestNumber {

	static BufferedReader in = new BufferedReader (new InputStreamReader(System.in));

	public static void main(String[] args) {
		System.out.println("How many numbers would you like to imput?");
		int[] x = null;
		try {
			x = new int[Integer.parseInt(in.readLine())];
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Please input the numbers.");
		for (int i = 0; i < x.length; i++){
			try {
				x[i] = Integer.parseInt(in.readLine());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		System.out.println("The largest of the inputted numbers is " + largestNum(x));
	}
	/**
	 * finds the largest number in the inputed array
	 * @param array of integers 
	 * @return the largest number in the array
	 */
	public static int largestNum(int[] array){
		int largestNumber = array[0];
		for (int i = 1; i < array.length; i++){
			if (array[i] > largestNumber){
				largestNumber =  array[i];
			}
		}
		return largestNumber;
	}
}
