/////////////////////////////////////////////////////////////////////////////
//   USAGE:
//       java 1.8 TicTacToe.java
//   DESCRIPTION:
//       A mini game of tic tac toe in java where there are two players
//       that can mark an "X" or a "Y" to get 3 of their mark in a row,
//		 a column, or diagonally. 
//---------------------------------------------------------------------------
//   CREATED BY: Deborah Perez
//   VERSION:    20180503
/////////////////////////////////////////////////////////////////////////////
//File TicTacToe.java 

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		playTicTacToe();
	}
// -playTicTacToe------------------------------------------------------------
	private static void playTicTacToe() {
		String[][] board = {
				{"[ ]", "[ ]", "[ ]"},
				{"[ ]", "[ ]", "[ ]"},
				{"[ ]", "[ ]", "[ ]"}
		};

		Scanner scan = new Scanner(System.in);
		for (int i=1 ; i<=9 ; i++) {
			// player 1
			if (i%2 != 0) {
				String mark = "X";
				System.out.println("Round: " + i);
				boardCurrentState(board);
				performRound(scan, mark, 1, i, board);
				System.out.println();
				if (isAWinner(board, mark)) {
					System.out.println("********Player 1 Wins!********");
					boardCurrentState(board);
					break;
				}
			}
			// player 2
			else if (i%2 == 0) {
				String mark = "Y";
				System.out.println("Round: " + i);
				boardCurrentState(board);
				performRound(scan, "Y", 2, i, board);
				System.out.println();
				if (isAWinner(board, mark)) {
					System.out.println("********Player 2 Wins!********");
					boardCurrentState(board);
					break;
				}
			}
		}
		System.out.println("**********GAME  OVER**********");

	}			
// -------------------------------------------------------------------------
// -isAWinner checks if the player has won based on it's pattern------------
	private static boolean isAWinner(String[][] board, String mark) {
		String trueMark = "[" + mark + "]";
		// three across first row
		if (board[0][0].equals(trueMark) && board[0][1].equals(trueMark) 
				&& board[0][2].equals(trueMark)) {
			return true;
		}
		// three across middle row
		else if (board[1][0].equals(trueMark) && board[1][1].equals(trueMark) 
				&& board[1][2].equals(trueMark)){
			return true;
		}
		// three across bottom row
		else if (board[2][0].equals(trueMark) && board[2][1].equals(trueMark) 
				&& board[2][2].equals(trueMark)){
			return true;
		}
		// three diagonal left to right 
		else if (board[0][0].equals(trueMark) && board[1][1].equals(trueMark) 
				&& board[2][2].equals(trueMark)){
			return true;
		}
		// three diagonal right to left
		else if (board[0][2].equals(trueMark) && board[1][1].equals(trueMark) 
				&& board[2][0].equals(trueMark)){
			return true;
		}
		// three down left most column
		else if (board[0][0].equals(trueMark) && board[1][0].equals(trueMark) 
				&& board[2][0].equals(trueMark)){
			return true;
		}
		// three down middle column
		else if (board[0][1].equals(trueMark) && board[1][1].equals(trueMark) 
				&& board[2][1].equals(trueMark)){
			return true;
		}
		// three down right most column
		else if (board[0][2].equals(trueMark) && board[1][2].equals(trueMark) 
				&& board[2][2].equals(trueMark)){
			return true;
		}
		return false;
}
// -performRound---------------------------------------------------------------
	private static void performRound(Scanner scan, String mark, int player, 
			int i, String[][] board) {
		String trueMark = "[" + mark + "]";
		int row = 0;
		int column = 0;
		
		// Loop player's turn until row and column chosen are a free space
		do {
			System.out.println("Player: " + player + " pick a row and column "
			+ "that " + "you would like to place your mark " + mark + " on.");
			System.out.print("Enter Row: ");
			row = scan.nextInt();
			System.out.print("Enter Column: ");
			column = scan.nextInt();
		// check is space is free
		} while (spaceFree(board, row, column)==false);
			board[row-1][column-1] = trueMark;
	}
// -spaceFree------------------------------------------------------------------
	private static boolean spaceFree(String[][] board, int row, int column) {
		if (board[row-1][column-1].equals("[ ]")) {
			return true;
		}
		else {
			return false;
		}
	}
// -boardCurrentState----------------------------------------------------------
	private static void boardCurrentState(String[][] board) {
		System.out.println("Current Board");
		System.out.println("   " + 1 + "   " + 2 + "   " + 3);
		printString2DArray(board);
}
// -printStringArray-----------------------------------------------------------
	public static void printString2DArray(String[][] array) {
		int counter = 1;
		for (String[] x : array) {
			System.out.print(counter + " ");
			counter+=1;
			for (String y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}
// ----------------------------------------------------------------------------
}