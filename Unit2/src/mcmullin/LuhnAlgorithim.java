package mcmullin;

import java.util.Scanner;

public class LuhnAlgorithim {


	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		String output = "";
		if (total(s, secondDigitTotal(s))%10 == 0){
			output += '0';
		}

	}
	public static int secondDigitTotal(String a){
		char[] number = a.toCharArray();
		int total = 0;
		for (int i = number.length-1; i >= 0 ; i--){
			if (i%2 == 1 && number.length%2 == 1){
				if ((Character.getNumericValue(number[i]) * 2) > 9){
					int x = Character.getNumericValue(number[i])*2;
					total += (x%10 + 1);
				}
				else{
					total += Character.getNumericValue(number[i]) * 2;
				}
			}
			else if(i%2 == 0 && number.length%2 == 0){
				if ((Character.getNumericValue(number[i]) * 2) > 9){
					int x = Character.getNumericValue(number[i])*2;
					total += (x%10 + 1);
				}
				else{
					total += Character.getNumericValue(number[i]) * 2;
				}
			}
		}
		return total;
	}
	public static int total(String a, int y){
		char[] number = a.toCharArray();
		int total = 0;
		for (int i = number.length-1; i >= 0 ; i--){
			if (i%2 == 0 && number.length%2 == 1){
				total += Character.getNumericValue(number[i]);
			}
			else if(i%2 == 1 && number.length%2 == 0){
				total += Character.getNumericValue(number[i]);
			}
		}
		return (total + y);
	}
	public static int checkNum(int a){
		if (a%10 == 0){
			return 0;
		}
		else{
			return (10 - (a%10));
		}
	}

}

