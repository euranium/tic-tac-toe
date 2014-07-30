/* Rainier Harvey
 * 2014-07-15T22:50:36
 * compLogic
 */
import java.util.*;
public class compLogic{
	private static int [][] board;
	private static int [][] sums;

	public static int [][] boardEval(){
		board = Board.boardVal();
		int i, j, n;
		sums = new int[8][2];
		// array that stores the possition of the best row/col
		// 8 arrays of {sum, row/col#]
		n = 0;
		//varialbe for storing 
		for (i = 0; i<8; i++)
			sums[i][0] = 0;
		sums[n][1] = n;

		for (i = 0; i < 3; i++){
			for (j = 0; j < 3; j++)
				sums[n][0] += board[i][j];
			sums[n][1] = n;
			n++;
		}
			// sums up each row/col/diag for best sum
			// with saving the value of each poss
			// then finds the best poss that is not already taken
		for (i = 0; i < 3; i++){
			for (j = 0; j < 3; j++)
				sums[n][0] += board[j][i];
			sums[n][1] = n;
			n++;
		}

		for (i = 0; i < 3; i++)
			sums[n][0] += board[i][i];
		sums[n][1] = n;
		n++;

		sums[7][0] += board[0][2];
		sums[7][0] += board[1][1];
		sums[7][0] += board[2][0];
		sums[n][1] = n;
		return sums;
	}

	public static int [][] getSums(){
		return sums;
	}

	public static int[][] findBest(int [][] sums){
		Arrays.sort(sums, new Comparator<int[]>() {
			public int compare(int[] a, int[] b){
				return Double.compare(b[0], a[0]);
			}
		});
		return sums;
	}

	public static int[] bestPoss(int [][] sum){
		int[] poss = new int [3];
		// the best possition
		int [] sums = sum[0];
		// the value and poss number of the best row/col
		int b = 1;
		int n = 0;
		board = Board.boardVal();
		//value of board
		int i, j;
		//counters
		int summing  = 0;
		// the sum values of the rows/col
		int [][] summation = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		// an array to store the values of the possitions
		do{
		if (sums[1] < 3){
			for(i = 0; i < 3; i++){
				for (j = 0; j < 3; j++)
					summing += board[i][j];
			if (summing == sums[0]){
				for (j = 0; j < 3; j++)
					if (board[i][j] < 6 && board[i][j] > 0){ 
						summation[n][0] = board[i][j];
						summation[n][1] = i;
						summation[n][2] = j;
						n++;
					}
			}
			summing = 0;
			}
		}
		else if (sums[1] < 6){
			for (i = 0; i < 3; i++){
				for (j = 0; j < 3; j++)
					summing += board[j][i];
			if (summing == sums[0]){
				for (j = 0; j < 3; j++)
					if (board[j][i] < 6 && board[j][i] > 0){ 
						summation[n][0] = board[j][i];
						summation[n][1] = j;
						summation[n][2] = i;
						n++;
					}
			}	
			summing = 0;
			}
		}
		else if (sums[1] == 6){
			for (i = 0; i < 3; i++){
				if (board[i][i] > 0 && board[i][i] < 6){
					summation[n][0] = board[i][i];
					summation[n][1] = i;
					summation[n][2] = i;
					n++;
				}
			}
		}
		else if (sums[1] == 7){
			for (i = 2; i > -1; i--){
				if (board[i][2-i] > 0 && board[i][2 - i] < 6){
					summation[n][0] = board[i][2 - i];
					summation[n][1] = i;
					summation[n][2] = 2 - i;
					n++;
				}
			}
		}
		n = 0;
		sums = sum[b];
		b++;
		} while (summation[0][0] == 0);
		summation = findBest(summation);
		poss = summation[0];
		return poss;
	}

	public static int[] playerBlock(int a, int b){
		int [] move = new int [2];
		int i, j;
		int summing = 0;
		board = Board.boardVal();
		if (b < 3){
			for(i = 0; i < 3; i++){
				for (j = 0; j < 3; j++)
					summing += board[i][j];
				if (summing == a){
					for (j = 0; j < 3; j++){
						if (board[i][j] > 0){ 
						move[0] = i;
						move[1] = j;
					}
				}
			}
			summing = 0;
			}
		}
		else if (b < 6){
			for (i = 0; i < 3; i++){
				for (j = 0; j < 3; j++)
					summing += board[j][i];
			if (summing == a){
				for (j = 0; j < 3; j++)
					if (board[j][i] > 0){ 
						move[0] = j;
						move[1] = i;
					}
			}
			summing = 0;
			}
		}
		else if (b == 6){
			for (i = 0; i < 3; i++){
				if (board[i][i] > 0){
					move[0] = i;
					move[1] = i;
				}
			}
		}
		else if (b == 7){
			for (i = 2; i > -1; i--){
				if (board[2-i][i] > 0){
					move[0] = 2-i;
					move[1] = i;
				}
			}
		}
		return move;
	}
}
