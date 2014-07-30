/* Rainier Harvey
 * 2014-07-06T14:02:10
 * playerIO
 */

import java.util.Scanner;
public class playerIO{
	public static int[]  playerMove(char XorO){
		int[] move = {3, 3};
		// intialize array with 3, 3 to appease compiler
		Scanner input = new Scanner(System.in);
		String playerI;
		do {
			System.out.println("Enter a row (1,2,3) for player"+ XorO + ":");
			playerI= input.nextLine();
			playerI= playerI.trim();
			move[0] = Character.getNumericValue(playerI.charAt(0)) - 1;
		} while (move[0] > 2 || move[0] < 0 || playerI.length() > 1);
		// gets user input as a string then converts to an int
		// checks to int 
		do {
			System.out.println("Enter a column (1,2,3) for player"+ XorO + ":");
			playerI= input.nextLine();
			playerI= playerI.trim();
			move[1] = Character.getNumericValue(playerI.charAt(0)) - 1;
		} while (move[1] > 2 || move[1] < 0 || playerI.length() > 1);
	return move;
	// creates an array with the two moves
	// checkes to make sure both moves are within the peramiters
	}

	public static char getPlayerDifficulty(){
		Scanner input = new Scanner(System.in);
		char[] diff = {'e', 'E', 'm', 'M', 'h', 'H'};
		String playerI;
		char chars;
		do {
			System.out.println("What difficulty do you want to play at, easy(E), medium(M) or hard(H)?" + '\n' +"easy, the computer moves randomly, medium, the coputer is only agressive, hard, the computer moves first and is defensive and aggressive:");
			playerI = input.nextLine();
			playerI = playerI.trim();
			chars = playerI.charAt(0);
			// gets usr input as string then gets the first char in string
			// trims white space
		} while (playerI.length() > 1);
		for (int i = 0; i < diff.length; i++){
			if (chars == diff[i])
				return diff[i];
			}
		return ' ';
		// gets a user input for what level difficulty they want
		// makes sure it is in the peramiters
	}
	public static char getPlayerChar(){
		Scanner input = new Scanner(System.in);
		char diff;
		String playerI;
		do {
			System.out.println("Do you want to be 'X' or 'O' (x moves first)?:");
			playerI = input.nextLine();
			playerI = playerI.trim();
			diff = playerI.charAt(0);
		if (diff == 'x' || diff == 'X' && playerI.length() > 1) 
			return 'X';
		if (diff == 'o' || diff == 'O' && playerI.length() > 1)
			return 'O';
		diff = ' ';
		}while(diff == ' ' || playerI.length() > 1);
		return ' ';
		// gets user input for being x or o 
	}

	public static char getGameType(){		
		Scanner input = new Scanner(System.in);
		char diff;
		String playerI;
		do {
			System.out.println("Do you want to play against a computer(C) or another player(P)?: ");
			playerI = input.nextLine();
			playerI = playerI.trim();
			diff = playerI.charAt(0);
			if (diff == 'c' || diff == 'C' && playerI.length() > 1)
				return 'C';
			if (diff == 'p' || diff == 'P' && playerI.length() > 1)
				return 'P';
			diff = ' ';
		}while (diff == ' '); 
		return diff;
		// gets user input for playing two player or computer
	}

	public static boolean cont(){
		Scanner input = new Scanner(System.in);
		char diff;
		String playerI;
		do {
			System.out.println("Do you want to play again? ");
			playerI = input.nextLine();
			playerI = playerI.trim();
			diff = playerI.charAt(0);
			if (diff == 'y' ||diff == 'Y')
				return true;
			else if (diff == 'n' || diff == 'N') 
				return false;
			diff = ' ';
		} while (diff == ' ' || playerI.length() > 1);
		return false;
	}

}

