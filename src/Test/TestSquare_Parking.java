package Test;
import Monopoly.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSquare_Parking {
	public Square_Parking square_Parkingt;
	public String name;
	
	//test doAction Jailpass=false 
	@Test
	public void testdoAct3() throws Exception {
		setOutput();
		name = "Parking";
		Square_Parking square_Parkingt = new Square_Parking(name);
		Player[] players = {new Player(1,"John",null)};
		Board board = new Board(players);
		square_Parkingt.doAction(players[0], board);
		String expected_result = "Nothing Happen.";
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	//Test for getDetails result: John 
	public void testget() {
		name = "Parking";
		Square_Parking square_Parkingt = new Square_Parking(name);
		String result_GD = square_Parkingt.getDetails();
		assertEquals("Parking",result_GD);
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
