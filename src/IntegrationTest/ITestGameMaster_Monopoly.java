package IntegrationTest;

import static org.junit.Assert.*;

import org.junit.Test;

import Monopoly.Board;
import Monopoly.Die;
import Monopoly.GameMaster;
import Monopoly.Monopoly;
import Monopoly.Player;

public class ITestGameMaster_Monopoly {
	
	@Test
	public void isGameEndV1() throws Exception {
		
		Player[] players = {new Player(1,"John",null)};
		Monopoly monopoly = new Monopoly(players);
		Board board = new Board(players);
		Die die = new Die();
		GameMaster gm;
		
		players[0].setBrokeOut(false);
		board.getCurrentPlayer().setBrokeOut(false);
		
		GameMaster.getInstance().initGame();
		
		boolean result = monopoly.isGameEnd();
		assertEquals(result, false);
		
		// gm.getInstance().initGame();
		
	}
}

