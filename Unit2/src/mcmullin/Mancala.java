/**
 * 
 */
package mcmullin;

import java.util.Scanner;

/**
 * @author Cole McMullin
 *
 */
public class Mancala {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] board = initBoard();
		int player = 1;
		System.out.println("Player 1 is top and player 2 is bottom.");
		while(!gameEnd(board)){
			printBoard(board);
			System.out.println("");
			System.out.println("Player " + player);
			System.out.println("");

			move(board , player);
			if (player == 1){
				player++;
			}
			else {
				player--;
			}
		}
		if (board[1][7] > board[1][0]){
			System.out.println("Player 1 wins!");
		}
		if (board[1][7] == board[1][0]){
			System.out.println("Tie Game");
		}
		if (board[1][7] < board[1][0]){
			System.out.println("Player 2 wins!");
		}
	}

	public static boolean gameEnd( int[][] board){
		for(int i = 1; i < 7; i++){
			if (board[0][i] > 0){
				return false;
			}
		}
		for(int i = 1; i < 7; i++){
			if (board[3][i] > 0){
				return false;
			}
		}
		return true;
	}

	public static  int[][] move(int[][] board, int player){

		System.out.println("What is the column letter of the pit you would like to take stones from?");
		char[] input = in.nextLine().toCharArray();
		char columnChar = input[0];
		int column = columnNumber(columnChar);
		int row;
		int stones;

		if (player == 1){
			row = 0;
			stones = board[row][column];
			board [row][column] = 0;

			for(int i = 1; i <= stones; i++){

				if (column + i == 7){
					board[row + 1][column + i]++;
				}
				else if(column + i > 7){
					board[row + 2][7 - ((column + i)-7)]++;
				}
				else {
					board[row][column + i]++;
				}
				if(i == stones){
					if (column + i == 7){
						row++;
						column += i;
					}
					else if(column + i > 7){
						row += 2;
						column = 7 - ((column + i)-7);
					}
					else {
						column += i;
					}

					if(row == 1 && column == 7){
						printBoard(board);
						move(board , player);
					}

					if(board[row][column]-1 == 0 && row == 0){
						row += 2; 
						board[1][7] += board[row][column];
						board[row][column] = 0;
						printBoard(board);
						move(board , player);
					}
				}
			}
		}
		else {
			row = 2;
			stones = board[row][column];
			board [row][column] = 0;

			for(int i = 1; i <= stones; i++){
				if (column - i == 0){
					board[row - 1][column - i]++;
				}
				else if(column - i < 0){
					board[row - 2][0 - (column - i)]++;
				}
				else{
					board[row][column - i]++;
				}
				if(i == stones){
					if (column - i == 0){
						row--;
						column -= i;
					}
					else if(column - i < 0){
						row -= 2;
						column = 0 - (column - i);
					}
					else {
						column -= i;
					}

					if(row == 1 && column == 0){
						printBoard(board);
						move(board , player);
					}

					if(board[row][column]-1 == 0 && row == 2){
						row -= 2; 
						board[1][0] += board[row][column];
						board[row][column] = 0;
						printBoard(board);
						move(board , player);
					}
				}
			}
		}
		return board;
	}

	public static int columnNumber(char c){
		switch(c){
		case 'A': return 1;
		case 'B': return 2;
		case 'C': return 3;
		case 'D': return 4;
		case 'E': return 5;
		case 'F': return 6;
		}
		return 0;
	}

	public static int[][] initBoard(){
		int[][] board = new int[3][8];
		for(int i = 1; i < 7; i++){
			board[0][i] = 3;
		}
		for(int i = 1; i < 7; i++){
			board[2][i] = 3;
		}
		board[1][0] = 0;
		board[1][7] = 0;
		return board;
	}

	public static void printBoard( int[][] board){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 8; j++){
				if((i==0 && (j == 0 || j == 7)) || (i==2 && (j == 0 || j == 7))){
					if(j == 7){
						System.out.print("  \n");
					}
					else if (j == 0){

						System.out.print("  ");
					}
				}
				else if(i == 1 && (j>0 && j < 7)){
					System.out.print("  ");
				}
				else if(j == 7){
					System.out.println(board[i][j]);
				}
				else if(j == 0){
					System.out.print(board[i][j] + " ");

				}
				else{
					System.out.print(board[i][j] + " ");
				}
			}
		}
		System.out.println("  A B C D E F  ");
	}
}
