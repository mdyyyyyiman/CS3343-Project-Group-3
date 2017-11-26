package Monopoly;

public enum Token {
	boot(0),
	cannon(1),
	cat(2),
	horse(3),
	lantern(4),
	lenguin(5),
	racecar(6),
	hat(7);
	
	private int tokenId;
	
	Token(int tId){
		this.tokenId = tId;
	}
	public int getTokenId() {
		return tokenId;
	}
	public static boolean hasThisToken(String token) {
		
		for(Token t: Token.values()) {
			if (t.name().equals(token)) {
	            return true;
	        }
		}
		return false;
	}
}
