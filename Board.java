/* Rainier Harvey
 * 2014-07-06T19:10:37
 * Board
 */

import java.io.*;
import java.util.Arrays;
public class Board{
	private static char [][] board;
	private static int [][] boardVal;

	public  Board(){
		board = new char[3][3];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[i].length; j++)
				board[i][j] = ' ';
		// initializes a new board
		// with all empy spaces
	}
	public static void setBoardVal(){
		int [][] temp = {{4, 3, 4}, {3, 5, 3}, {4, 3, 4}};
		boardVal = temp;
		return;
	}

	public static void drawBoard(){
		System.out.print('\n' +"--------------"+'\n' +"| ");
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++)
				System.out.print(board[i][j] +" | ");
			System.out.print('\n' + "--------------"+'\n'+"| ");
		}
		// will print out the board 
		// with all the player chars on them
		return;
	}

	public static int[][] boardVal(){
		return boardVal;
	}

	public static void compMove(int [] move, char player){
		board[move[0]][move[1]] = player;
		boardVal[move[0]][move[1]] = boardVal[move[0]][move[1]]*2;
		return;
		//sets the comps move
		//reassigns the value of the comps move poss 
		//as twice the value
	}

	public static int[][] getValue(){
		return boardVal;
	}

	public static void move(char player){
		int[] move = new int[2];
		int i = 0;
		// counts the nubmer of times the player has enterd moves
		// if move than 0 then prompts the player with error message
		do{
			if (i > 0)
				System.out.println("That was not a valid move, please try again");
			move = playerIO.playerMove(player);
		} while (checkMove(move) == false);
		// has player enter moves while the move is not valid
		board[move[0]][move[1]] = player;
		boardVal[move[0]][move[1]] = 0;
		return;
	}


	public static boolean checkMove(int[] move){
		return (board[move[0]][move[1]] == ' ');
		// tests if poassition is taken or not
	}

	public static boolean gameOver(){
		int XWIN = (int)'X' * 3;
		int OWIN = (int)'O' * 3;
		int sum = 0;
		for (int i = 0; i < board.length; i++){
			sum = 0;
			for (int j = 0; j < board[i].length; j++)
				sum += (int)board[i][j];
			// tests across 
			if (sum == XWIN){
				System.out.println("X is the Winner");
				return true;
			}
			if (sum == OWIN){
				System.out.println("X is the Winner");
				return true;
			}
		}
		for (int i = 0; i < board.length; i++){
			sum = 0;
			for (int j = 0; j < board[i].length; j++)
				sum += (int)board[j][i];
			// tests collums
			if (sum == XWIN){
				System.out.println("X is the Winner");
				return true;
			}
			if (sum == OWIN){
				System.out.println("X is the Winner");
				return true;
			}
		}
		sum = 0;
		for (int i = 0; i < board.length; i++){
			sum += (int)board[i][i];
			// tests diaganol
			if (sum == XWIN){
				System.out.println("X is the Winner");
				return true;
			}
			if (sum == OWIN){
				System.out.println("X is the Winner");
				return true;
			}
		}
		sum = 0;
		sum += (int)board[0][2];
		sum += (int)board[1][1];
		sum += (int)board[2][0];
			// tests reverse diaganoal
			// to lazy to redo whole for loop for 
			// just one diaganal
		if (sum == XWIN){
			System.out.println("X is the Winner");
			return true;
		}
		if (sum == OWIN){
			System.out.println("X is the Winner");
			return true;
		}
		if (Game.getMoves() > 9){
			System.out.println("Cats game");
			try{
				BufferedReader br = new BufferedReader(new FileReader("catEmoji.txt"));
				String line = null;
				try{ 
					while ((line = br.readLine()) != null)
					System.out.println(line);
				}
				catch (IOException ex){}
			}
			catch (IOException ex){}
			return true;
			// prints out a text rendered cat 
			// and ends the game with 
			// no more moves
		}
		return false;
	}

	public static void changeVal(int poss[]){
		boardVal[poss[0]][poss[1]] = poss[3];
		return;
	}

	public static int[]  playerMoveWin(){
		int [][] sums = compLogic.getSums();
		int [] returnType = {-1, -1};
		// sets the array to -1 by default
		// this tells if the array is empty
		// and cant just be set to empty
		for (int i = 0; i < 8; i++)
			if (sums[i][0] < 6){
				returnType[0] = sums[i][0];
				returnType[1] = sums[i][1];
				System.out.println(i);
				return returnType;
			}
		return returnType;
	}

	public static boolean moveWin(int [] move){
		int XWIN = (int)'X' * 3;
		board[move[0]][move[1]] = 'X';
		int sum = 0;
		for (int i = 0; i < board.length; i++){
			sum = 0;
			for (int j = 0; j < board[i].length; j++)
				sum += (int)board[i][j];
			// tests across 
			if (sum == XWIN)
				return true;
		}
		for (int i = 0; i < board.length; i++){
			sum = 0;
			for (int j = 0; j < board[i].length; j++)
				sum += (int)board[j][i];
			// tests collums
			if (sum == XWIN)
				return true;
		}
		sum = 0;
		for (int i = 0; i < board.length; i++){
			sum += (int)board[i][i];
			// tests diaganol
			if (sum == XWIN)
				return true;
		}
		sum = 0;
		sum += (int)board[0][2];
		sum += (int)board[1][1];
		sum += (int)board[2][0];
			// tests reverse diaganoal
			// to lazy to redo whole for loop for 
			// just one diaganal
		if (sum == XWIN)
			return true;
		board[move[0]][move[1]] = ' ';
		return false;
	}
}
