/* Rainier Harvey
 * 2014-07-13T20:58:13
 * tic
 */

public class tic{
	public static void main(String[] args){
		char check = ' ';
		char game;
		do{
		game = playerIO.getGameType();
		if (game == 'c' || game == 'C')
			Player.onePlayerGame();
		else if (game =='p' || game == 'P')
			Player.twoPlayerGame();
		} while (playerIO.cont() == true);
	return;
	}
}
