/* Rainier Harvey
 * 2014-07-07T19:26:08
 * Comp
 */
import java.util.*;

public class Comp{
	private static Random rand = new Random();
	public static void eMove(char XO){
		//rand = new Random();
		int[] move = new int[2];
		do {
			move[0] = rand.nextInt(3);
			move[1] = rand.nextInt(3);
		} while (Board.checkMove(move) == false);
		Board.compMove(move, XO);
		return;
	}

	public static void mMove(char XO){
		int [][] boardLook = compLogic.boardEval();
		int [][] values = compLogic.findBest(boardLook);
		int [] poss = compLogic.bestPoss(boardLook);
		int [] move = {poss[1], poss[2]};
		Board.compMove(move, XO);
		return;
	}

	public static void hMove(){
		int [][] boardLook = compLogic.boardEval();
		// gets the values of the summation of each
		// row/col 
		int [][] values = compLogic.findBest(boardLook);
		// rearanges the boardLook array into order 
		// by largest summation
		int [] poss = compLogic.bestPoss(boardLook);
		// finds the best possition for 
		// agressive move
		int[] move = {poss[1], poss[2]};
		// takes just the board possition 
		// without the row/col number
		int [] check = Board.playerMoveWin();
		// checks if the other player is about to win
		// and saves the row/col number of the win
		if (Board.moveWin(move) == true)
			// checks if the comp is about 
			// to win and then moves if it is
			;
		else if (check[0] != -1){
			// checks to check if the other player
			// is about to win then acts
			move = compLogic.playerBlock(check[0], check[1]);
			// finds the possition to block the playaer
			Board.compMove(move, 'X');
		}
		else
			Board.compMove(move, 'X');
		return;
	}
}
