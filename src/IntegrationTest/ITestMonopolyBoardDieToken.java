package IntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Monopoly.Board;
import Monopoly.Die;
import Monopoly.Monopoly;
import Monopoly.Player;
import Monopoly.Token;

public class ITestMonopolyBoardDieToken {
	
	@Test
	public void movePlayerV1() throws Exception {	// !isBrokeOut
		
		Player[] players = {new Player(1,"John", null)};
		Board board = new Board(players);
		Die die = new Die();
		Monopoly monopoly = new Monopoly(players);
		Token token;
		
		players[0].setBrokeOut(false);
		
		if(!players[0].isBrokeOut())
			monopoly.startGame();
		
	}
	
	
	@Test
	public void movePlayerV2() throws Exception {	// isBrokeOut
		
		Player[] players = {new Player(1,"John", null)};
		Board board = new Board(players);
		Die die = new Die();
		Monopoly monopoly = new Monopoly(players);
		Token token;
		
		players[0].setBrokeOut(true);
		
		if(players[0].isBrokeOut())
			board.nextTurn();
		
		//...
		
	}
}
