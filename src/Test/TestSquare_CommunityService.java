package Test;
import Monopoly.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class TestSquare_CommunityService {
	public Square_CommunityService square_cst;
	public String name;

	//test doAction card=1
	@Test
	public void testdoAct1() throws Exception {
		setOutput();
		Square_CommunityService square_cst = new Square_CommunityService(name);
		Player[] players = {new Player(1,"John",null,false)};
		Board board = new Board(players);
		square_cst.setCardDrew(1);
		square_cst.doAction(players[0], board);
		String expected_result = "You have draw the Jail Pass";
		assertEquals(expected_result, getOutput());
	}
	
	//test doAction card=2
	@Test
	public void testdoAct2() throws Exception {
		setOutput();
		Square_CommunityService square_cst = new Square_CommunityService(name);
		Player[] players = {new Player(1,"John",null,false)};
		Board board = new Board(players);
		square_cst.setCardDrew(2);
		square_cst.doAction(players[0], board);
		String expected_result = "You have won the jackpot! Gain $300";
		assertEquals(expected_result, getOutput());
	}
	
	//test doAction card=3
		@Test
		public void testdoAct3() throws Exception {
			setOutput();
			Square_CommunityService square_cst = new Square_CommunityService(name);
			Player[] players = {new Player(1,"John",null,false)};
			Board board = new Board(players);
			square_cst.setCardDrew(3);
			square_cst.doAction(players[0], board);
			String expected_result = "No Card can be draw !";
			assertEquals(expected_result, getOutput());
		}
	
	
	@Test
	//Test for getDetails result: John 
	public void testget() {
		name = "Tax";
		Square_CommunityService square_cst = new Square_CommunityService(name);
		String result_GD = square_cst.getDetails();
		assertEquals(name,result_GD);
	}
	
	//setOutput getOutput
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() throws Exception { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString().trim();
	}

}
