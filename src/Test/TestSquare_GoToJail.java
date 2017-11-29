package Test;
import Monopoly.*;
//package Monopoly

import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSquare_GoToJail {
	public Square_GoToJail square_gojailt;
	public String name;
	
	//test doAction Jail = square10
	@Test
	public void testdoAct() throws Exception {
		setOutput();
		name = "GoToJail";
		Square_GoToJail square_gojailt = new Square_GoToJail(name);
		Player[] players = {new Player(1,"John",null)};
		Board board = new Board(players);
		square_gojailt.doAction(players[0], board);
		String expected_result = players[0].getName() +" has go to Jail."+board.movePlayer(players[0], -1, false);;
				assertEquals("GoToJail", getOutput());
		
	}
	//?????????
	
	@Test
	//Test for getDetails result: John 
	public void testget() {
		name = "GoToJail";
		Square_GoToJail square_gojailt = new Square_GoToJail(name);
		String result_GD = square_gojailt.getDetails();
		assertEquals("GoToJail",result_GD);
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
		return bos.toString();
	}

}
