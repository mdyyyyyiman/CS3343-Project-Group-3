package Test;
import Monopoly.*;
//package Monopoly;

import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestSquare_Go {
	
	public Square_Go square_got;
	public String name;
	public String bonus_str;
	
	//test doAction
	@Test
	public void testdoAct() throws Exception {
		setOutput();
		name = "Go";
		bonus_str = "1000";
		Square_Go square_got = new Square_Go(name,bonus_str);
		Player[] players = {new Player(1,"John",null,false)};
		Board board = new Board(players);
		square_got.doAction(players[0], board);
		String expected_result = players[0].getName() + " is at Go... Giving 1000 money";
		assertEquals(expected_result, getOutput());
		
	}
	
	@Test
	//Test for getDetails result: John 50
	public void testget() {
		name = "Go";
		bonus_str = "50";
		square_got = new Square_Go(name,bonus_str);
		String result_GD = square_got.getDetails();
		assertEquals("Go 50",result_GD);
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

