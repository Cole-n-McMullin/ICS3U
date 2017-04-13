package mcmullin;

import java.util.Scanner;

public class IsPalendrome {
	
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String input = in.nextLine();
		System.out.println(isPalendrome(input));
	}
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
