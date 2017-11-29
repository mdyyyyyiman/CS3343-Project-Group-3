package Test;

import Monopoly.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSquare_Chance {
	public Square_Chance square_Chancet;
	public String name;
	
	//test doAction card=1
	@Test
	public void testdoAct1() throws Exception {
		setOutput();
		Square_Chance square_Chancet = new Square_Chance(name);
		Player[] players = {new Player(1,"John",null)};
		Board board = new Board(players);
		square_Chancet.doAction(players[0], board);
		square_Chancet.setCardDrew(1);
		String expected_result = "You have draw the Jail Pass";
		assertEquals(expected_result, getOutput());
	}
	
	//test doAction card=2
	@Test
	public void testdoAct2() throws Exception {
		setOutput();
		Square_Chance square_Chancet = new Square_Chance(name);
		Player[] players = {new Player(1,"John",null)};
		Board board = new Board(players);
		square_Chancet.setCardDrew(2);
		square_Chancet.doAction(players[0], board);
		String expected_result = "You have won the jackpot! Gain $300";
		assertEquals(expected_result, getOutput());
	}
	
	//test doAction card=3
		@Test
		public void testdoAct3() throws Exception {
			setOutput();
			Square_Chance square_Chancet = new Square_Chance(name);
			Player[] players = {new Player(1,"John",null)};
			Board board = new Board(players);
			square_Chancet.setCardDrew(3);
			square_Chancet.doAction(players[0], board);
			String expected_result = "No Card can be draw !";
			assertEquals(expected_result, getOutput());
		}
	
	@Test
	//Test for getDetails result: John 
	public void testget() {
		name = "Chance";
		Square_Chance square_Chancet = new Square_Chance(name);
		String result_GD = square_Chancet.getDetails();
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
