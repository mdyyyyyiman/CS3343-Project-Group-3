package IntegrationTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import Monopoly.Board;
import Monopoly.Die;
import Monopoly.Money;
import Monopoly.Player;
import Monopoly.Square;
import Monopoly.Square_Place;

public class ITestBoardSquarePlayer {
	
	@Before
	public void setUp() {

    }
	//test normalizePosition
	
	/* Need to test from start to all type of square (8 case)
	 * from any point to all type of square (8)
	 * from 39 passing go square
	 * 
	 * if broke out atFirst 
	 * if after broke out -> test output ( Can reference to Square_Place, of test system.println)
	 * 
	 * */
	//test move from start to 1 (place square)
	@Test
	public void movePlayerV1() throws Exception {	
		Player[] players = {new Player(1,"John", null,false)};
		Board board = new Board(players);
		Square square = board.movePlayer(players[0], 1);
		//assertThat(square,instanceOf(Square_Place.class));
		 assertEquals("TinShuiWai",square.getName());
	}
	
	
	@Test
	public void movePlayerV2() throws Exception {	
		
		Player[] players = {new Player(1,"John", null)};
		Board board = new Board(players);
		Die die = new Die();
		
		board.getPlayer(0);
		Square square = board.movePlayer(board.getCurrentPlayer(), players[0].tossDie(die));
		
	}
	

}
