package Test;

import Monopoly.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestMoney {
	public int amount;
	public Money moneyt;
	
	@Before
	public void setUp() {
		moneyt = new Money();
	}
	@After
	public void tarDown() {
		moneyt = null;
	}
	
	@Test
	//money =0 add $50 bal=50
	public void testadd() {
		amount=50;
		moneyt.addMoney(amount);
		int result= moneyt.getMoney();
		assertEquals(50, result);
	}
	
	@Test
	//money =0 sub $50 bal=-50
	public void testsub() {
	amount=50;
	moneyt.substractMoney(amount);
	int result= moneyt.getMoney();
	assertEquals(-50, result);
	}
	
	@Test
	//money=60 isBrokeOut=false
	public void testBrokeout() {
	Money moneyt = new Money(60);
	assertEquals(false,moneyt.isBrokeOut());
	}
	
	@Test
	//money=-60 isBrokeOut=true
	public void testBrokeout2() {
	Money moneyt = new Money(-60);
	assertEquals(true,moneyt.isBrokeOut());
	}
	
}
