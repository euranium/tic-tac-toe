/* Rainier Harvey
 * 2014-07-06T18:00:47
 * Game
 */

public class Game{
	/* constructor functions */

	private static char _diff;
	private static int _moves;
	private static char _player;
	private static Board board;

	public Game(char diff){
		_moves = 1;
		board = new Board();
		_diff = diff;
		if (_diff == 'h' || _diff == 'H')
			_player = 'O';
		else if (_diff == 'e' || _diff == 'm' || _diff == 'E' || _diff == 'M'){
			_player = playerIO.getPlayerChar();
			if (_player == 'x' || _player == 'X'){
				_player = 'X';
			}
			else
				_player = 'O';
		}
		// set the player character based on difficutly and player prefferance
		// no needed game character if two player
	}

	public static int getMoves(){
		return _moves;
	}

	public static void moves(){
		if (_moves % 2 == 0){
			if (_player == 'O')
				board.move('O');
			else{
				if (_diff == 'e')
					Comp.eMove('O');
				else 
					Comp.mMove('O');
			}
		}
		else{
			if (_player == 'X')
				board.move('X');
			else{
				if (_diff == 'e')
					Comp.eMove('X');
				else if (_diff == 'm')
					Comp.mMove('X');
				else
					Comp.hMove();
			}
		}
		_moves++;
		//counts moves and determines if it is x or o turn
		//x moves first and on every odd numbered turn
	}

	public static void playerMoves(){
		if (_moves % 2 == 0)
			board.move('O');
		else
			board.move('X');	
		_moves++;
	}
}
