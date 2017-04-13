package mcmullin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OrphanBlack {

	
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			BufferedReader sc = new BufferedReader(new FileReader(new File("unit2/DATA11.txt")));
			String dna;
			dna = sc.readLine();
			String irrelevant = sc.readLine();
			if (!(messageFinder(toBinary(dna, 1))).equals("")) {
				System.out.println(messageFinder(toBinary(dna, 1)));
			}
			else {
				System.out.println(messageFinder(toBinary(dna, 2)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String messageFinder(String s){
		String askee = "";
		int counter = 0;
		for (int i = 0; i < 7; i++){
			counter = i;
			askee = "";
			String a = ""; 
			while(((s.length()-1)-counter) >=8 && !a.equals(".")){
				a = getLetter(s.substring(counter, counter + 8));
				if(!a.equals(".") ){
					askee += a;
					counter += 8;
				}
			}
			if(!(((s.length()-1)-counter)>=8) && !a.equals(".")){
				return askee;
			}
		}

		return askee;
	}


	public static String toBinary(String s, int a){
		char[] catg = s.toCharArray();
		String output = "";
		for (int i = 0; i < s.length(); i++){
			if ((catg[i] == 'A' || catg[i] == 'T') && a == 1){
				output += '1';
			}
			else if ((catg[i] == 'C' || catg[i] == 'G') && a == 1){
				output += '0';
			}
			else if ((catg[i] == 'A' || catg[i] == 'T') && a == 2){
				output += '0';
			}
			else if ((catg[i] == 'C' || catg[i] == 'G') && a == 2){
				output += '1';
			}
		}
		return output;
	}

	public static String getLetter(String s) {

		switch (s) {
		case "00100000": return " ";//space
		case "01000001": return "A";
		case "01000010": return "B";
		case "01000011": return "C";
		case "01000100": return "D";
		case "01000101": return "E";
		case "01000110": return "F";
		case "01000111": return "G";
		case "01001000": return "H";
		case "01001001": return "I";
		case "01001010": return "J";
		case "01001011": return "K";
		case "01001100": return "L";
		case "01001101": return "M";
		case "01001110": return "N";
		case "01001111": return "O";
		case "01010000": return "P";
		case "01010001": return "Q";
		case "01010010": return "R";
		case "01010011": return "S";
		case "01010100": return "T";
		case "01010101": return "U";
		case "01010110": return "V";
		case "01010111": return "W";
		case "01011000": return "X";
		case "01011001": return "Y";
		case "01011010": return "Z";
		default: return ".";
		}
	}

}

