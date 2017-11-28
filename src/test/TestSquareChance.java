package test;

import static org.junit.Assert.*;
import Monopoly.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

public class TestSquareChance extends TestCase{
	@Before
	public void setUp() {
		GameMaster gm = GameMaster.getInstance();
		Monopoly game = gm.initGame();
		
    }
	
	
	@Test
	public void test() {
		Square_Chance sChance = new Square_Chance("Chance");
		Player p = new Player(999,"Test",Token.values()[8]);
		Board b = null;
		sChance.doAction(p,b);
	}

}
