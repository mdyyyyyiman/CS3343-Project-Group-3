package Test;
import Monopoly.*;
import static org.junit.Assert.*;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class TestSquare_Jail {
	public Square_Jail square_Jailt;
	public String name;

	
	//test doAction Jailpass=true use=Y
	
	@Test
	public void testdoAct1() throws Exception {
		setOutput();
		name = "Jail";
		Square_Jail square_Jailt = new Square_Jail(name);
		Player player = new Player(1,"John",null,false);
		Board board = null;
		player.setJailPass(true);
		String input = "Y";
		
		square_Jailt.doAction(player, board);
		String expected_result = "Do you want to use Jail Pass ?"+"\n"+"You have use the jail pass"+"\n";
		assertEquals(expected_result, getOutput());
	}

	
	//test doAction Jailpass=true use=N
	@Test
	public void testdoAct2() throws Exception {
		setOutput();
		name = "Jail";
		Square_Jail square_Jailt = new Square_Jail(name);
		Player[] players = {new Player(1,"John",null,false)};
		Board board = new Board(players);
		//players[0].jailPass=true;
		String cmd ="N";
		square_Jailt.doAction(players[0], board);
		String expected_result = "Do you want to use Jail Pass ?"+"\n"+players[0].getName() + " has been Jailed and lost $500"+"\n";
		assertEquals(expected_result, getOutput());
	}
	
	
	//test doAction Jailpass=false 
	@Test
	public void testdoAct3() throws Exception {
		setOutput();
		name = "Jail";
		Square_Jail square_Jailt = new Square_Jail(name);
		Player[] players = {new Player(1,"John",null,false)};
		Board board = new Board(players);
		square_Jailt.doAction(players[0], board);
		String expected_result = "";
		assertEquals(expected_result, getOutput());
	}
	
	
	//test doAction Jailpass=true use=Y
	@Test
	public void testdoAct() throws Exception {
		setOutput();
		name = "Jail";
		Square_Jail square_Jailt = new Square_Jail(name);
		Player[] players = {new Player(1,"John",null,false)};
		Board board = new Board(players);
		//players[0].jailPass=true;
		String cmd = "Y";
		square_Jailt.doAction(players[0], board);
		String expected_result = "Do you want to use Jail Pass ?"+"\n"+"You have use the jail pass"+"\n";
		assertEquals(expected_result, getOutput());
	}
	@Test
	//Test for getDetails result: John 
	public void testget() {
		name = "Jail";
		Square_Jail square_Jailt = new Square_Jail(name);
		String result_GD = square_Jailt.getDetails();
		assertEquals("Jail",result_GD);
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
