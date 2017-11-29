package Test;
import Monopoly.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSquare_Tax {
	public Square_Tax square_Taxt;
	public String name;
	public String price;

	//test doAction tax=50
	@Test
	public void testdoAct1() throws Exception {
		setOutput();
		name = "Tax";
		price ="50";
		Square_Tax square_Taxt = new Square_Tax(name,price);
		Player player = new Player(1,"John",null);
		Board board = null;
		square_Taxt.doAction(player, board);
		String expected_result = player.getName() +  " need to pay $"+ price + " tax.";
		assertEquals(expected_result, getOutput());
	}
	
	@Test
	//Test for getDetails result: John 50 
	public void testget() {
		name = "Tax";
		price ="50";
		Square_Tax square_Taxt = new Square_Tax(name,price);
		String result_GD = square_Taxt.getDetails();
		assertEquals("Tax 50",result_GD);
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
