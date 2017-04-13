package mcmullin;

import java.util.Scanner;
/**
 * isPalendrome.java
 * april 13 2017
 * @author Cole McMullin
 *gets a string from the user and tells them wether or not it is a palendrome
 */
public class IsPalendrome {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String input = in.nextLine();
		System.out.println(isPalendrome(input));
	}
	/**
	 * 
	 * @param s the input string
	 * @return weather or not the word is a palendrome
	 */
	public static boolean isPalendrome(String s){
		char[] letters = s.toCharArray();
		String inverse = "";
		for (int i = s.length()-1; i>=0; i--){
			inverse += letters[i];
		}
		if (inverse.equals(s)){
			return true;
		}
		return false;
	}
}
