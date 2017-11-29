package Test;
import Monopoly.*;

import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSquare_Place {
	public Square_Place square_placet;
	public String name;
	private String price;
	private String colour;
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	//????????
	
	@Test
	//Test for getPrice result: 50 
	public void testgetp() {
		price = "50";
		Square_Place square_placet = new Square_Place(colour,name,price);
		String result = square_placet.getDetails();
		assertEquals("50",result);
	}

	@Test
	//Test for getDetails result: John 
	public void testget() {
		name = "John";
		Square_Place square_placet = new Square_Place(colour,name,price);
		String result_GD = square_placet.getDetails();
		assertEquals("John",result_GD);
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
