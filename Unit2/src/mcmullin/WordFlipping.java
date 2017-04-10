package mcmullin;

import java.util.Scanner;

public class WordFlipping {
	

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] sentence  = in.nextLine().split(" ");
		String output = "";
		boolean period = false;
		boolean capital = false;
		
		for (int i = 0; i < sentence.length; i++){
			if(sentence[i].charAt(sentence[i].length()-1)== '.'){
				sentence[i] = sentence[i].replace('.', ' ');
				sentence[i] = sentence[i].trim();
				period = true;
			}
			
			if(((Character)(sentence[i].charAt(0))).toString().matches("[A-Z]")){
				capital = true;
			}
			
			char[] word = sentence[i].toCharArray();
			

			for (int j = word.length-1;  j >= 0 ; j--){

				if(capital && j == word.length-1){
					word[0] = Character.toLowerCase(word[0]);
					output += Character.toUpperCase(word[j]);
					capital = false;
				}
				else if (period && j== 0){
					output += word[j];
					output += '.';
					period = false;
				}	
				else{
					output += word[j];
				}	
			}
			System.out.print(output + " "); 
			output = "";
		}

	}
}
