package Test;
import Monopoly.*;

import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSquare_Place {
	public String name = "Victoria Peak";
	private String price = "400";
	private String colour = "blue";
	public Square_Place square_placet;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	

	@Test
	public void testDoAct_negative_Y() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		Player[] players = {new Player(1,"John",null,false)};
		System.setIn(new ByteArrayInputStream("Y".getBytes()));
		square_placet.doAction(players[0], new Board(players));
		String expected_result = (players[0].getName()+", do you want to it? (Y/N)"+"\n"+(players[0].getName() + " buy " + square_placet.getName() + " for " + square_placet.getPrice()+"\n")+(name+" now have $"+players[0].getMoney().getMoney()+" left."+"\n"));
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	public void testDoAct_negative_N() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		Player[] players = {new Player(1,"John",null,false)};
		System.setIn(new ByteArrayInputStream("N".getBytes()));
		square_placet.doAction(players[0], new Board(players));
		String expected_result = (players[0].getName() + " don't want to buy " + square_placet.getDetails()+"\n");
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	public void testDoAct_not_negative_not_owner_hotel() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		Player[] players = {new Player(1,"John",null,false), new Player(2,"Peter",null,false)};
		square_placet.setOwner(players[1].getID());
		square_placet.setEstate("hotel");
		square_placet.doAction(players[0], new Board(players));
		String expected_result = (players[0].getName() + " lost " + square_placet.getPrice()*0.7*2 + " money to " + players[1].getName()+"\n");
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	public void testDoAct_not_negative_not_owner_house() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		Player[] players = {new Player(1,"John",null,false), new Player(2,"Peter",null,false)};
		square_placet.setOwner(players[1].getID());
		square_placet.setEstate("house");
		square_placet.doAction(players[0], new Board(players));
		String expected_result = (players[0].getName() + " lost " + square_placet.getPrice()*0.7*1.5 + " money to " + players[1].getName()+"\n");
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	public void testDoAct_not_negative_owner_build_hotel_Y() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		square_placet.setEstate("house");
		Player[] players = {new Player(1,"John",null,false)};
		square_placet.setOwner(players[0].getID());
		System.setIn(new ByteArrayInputStream("Y".getBytes()));
		square_placet.doAction(players[0], new Board(players));
		String expected_result = ("Do you want to build a hotel ($100)? (Y/N)"+"\n"+players[0].getName()+" build a hotel on "+square_placet.getName()+"\n");
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	public void testDoAct_not_negative_owner_build_hotel_N() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		square_placet.setEstate("house");
		Player[] players = {new Player(1,"John",null,false)};
		square_placet.setOwner(players[0].getID());
		System.setIn(new ByteArrayInputStream("N".getBytes()));
		square_placet.doAction(players[0], new Board(players));
		String expected_result = ("Do you want to build a hotel ($100)? (Y/N)"+"\n"+players[0].getName()+" don't want to build a hotel on "+square_placet.getName()+"\n");
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	public void testDoAct_not_negative_owner_build_house_Y() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		Player[] players = {new Player(1,"John",null,false)};
		square_placet.setOwner(players[0].getID());
		System.setIn(new ByteArrayInputStream("Y".getBytes()));
		square_placet.doAction(players[0], new Board(players));
		String expected_result = ("Do you want to build a house ($50)? (Y/N)"+"\n"+players[0].getName()+" build a hotel on "+square_placet.getName()+"\n");
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	public void testDoAct_not_negative_owner_build_house_N() throws Exception {
		setOutput();
		square_placet = new Square_Place(colour, name, price);
		Player[] players = {new Player(1,"John",null,false)};
		square_placet.setOwner(players[0].getID());
		System.setIn(new ByteArrayInputStream("N".getBytes()));
		square_placet.doAction(players[0], new Board(players));
		String expected_result = ("Do you want to build a house ($50)? (Y/N)"+"\n"+players[0].getName()+" don't want to build a house on "+square_placet.getName()+"\n");
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	//Test for getPrice result: 50 
	public void testgetp() {
		square_placet = new Square_Place(colour,name,price);
		int result = square_placet.getPrice();
		assertEquals(400,result);
	}

	@Test
	//Test for getDetails result: John 
	public void testget() {
		square_placet = new Square_Place(colour, name, price);
		String result_GD = square_placet.getDetails();
		String expected_result = "Victoria Peak blue ($400)";
		assertEquals(expected_result,result_GD);
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
