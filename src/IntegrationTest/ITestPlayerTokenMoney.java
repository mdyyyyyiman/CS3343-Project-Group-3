package IntegrationTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Monopoly.Player;
import Monopoly.Token;

public class ITestPlayerTokenMoney {
	
	@Test
	public void testV1() throws Exception {
		
		Token ttoken = Token.cannon;
		
		Player[] players = {new Player(1,"John", ttoken)};
		String testToken = players[0].getToken().toString();
		
		boolean result = ttoken.hasThisToken(testToken);
		assertEquals(result, true);
		
		//Player.xxx
		
	}
	
	@Test
	public void testV2() throws Exception {
		
		Token ttoken = Token.horse;
		
		String customToken = "goose";

		Player[] players = {new Player(1,"John", ttoken)};
		String tempToken = players[0].getToken().name().replace(ttoken.toString(), customToken);	// replace exist token 'horse' with fake token 'goose'

		boolean result = ttoken.hasThisToken(tempToken);
		assertEquals(result, false);
		
		//Player.xxx

	}
}
