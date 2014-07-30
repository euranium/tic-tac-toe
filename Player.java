/* Rainier Harvey
 * 2014-07-06T14:01:00
 * Player
 */

public class Player{
	private static Game game;
	public static void onePlayerGame(){
		char difficult;
		do{
		difficult = playerIO.getPlayerDifficulty();
		} while (difficult == ' ');
		if (difficult == 'H' || difficult == 'h')
			game = new Game('h');
		else if (difficult == 'M' || difficult == 'm')
			game = new Game('m');
		else if (difficult == 'e' || difficult == 'E')
			game = new Game('e');
		// create a game object based on what the difficutly is
		Board.setBoardVal();
		do{
			Game.moves();
			Board.drawBoard();
		} while (Board.gameOver() == false );
		// loop through the game while there are still moves to be made and game is not over
			
	return;
	}

	public static void twoPlayerGame(){
		game = new Game('P');
		do {
			Game.playerMoves();
			Board.drawBoard();
		} while (Board.gameOver() == false);
		// loop through game while there are still moves to be made
		return;
	}
}
