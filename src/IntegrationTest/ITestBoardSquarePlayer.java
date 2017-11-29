package IntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Monopoly.Board;
import Monopoly.Die;
import Monopoly.Money;
import Monopoly.Player;
import Monopoly.Square;

public class ITestBoardSquarePlayer {
	
	@Test
	public void movePlayerV1() throws Exception {	// isBrokeOut
		
		Player[] players = {new Player(1,"John", null)};
		Board board = new Board(players);
		Die die = new Die();
		
		board.getPlayer(0);
		Square square = board.movePlayer(board.getCurrentPlayer(), players[0].tossDie(die));

	}
	
	
	@Test
	public void movePlayerV2() throws Exception {	// !isBrokeOut
		
		Player[] players = {new Player(1,"John", null)};
		Board board = new Board(players);
		Die die = new Die();
		
		board.getPlayer(0);
		Square square = board.movePlayer(board.getCurrentPlayer(), players[0].tossDie(die));
		
	}
}
