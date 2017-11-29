package Monopoly;

public enum Token {
	boot(0,false),
	cannon(1,false),
	cat(2,false),
	horse(3,false),
	lantern(4,false),
	lenguin(5,false),
	racecar(6,false),
	hat(7,false);
	
	private int tokenId;
	private boolean using;
	
	Token(int tId, boolean using){
		this.tokenId = tId;
		this.using = using;
	}
	public boolean isUsing() {
		return using;
	}
	public void setUsing(boolean using) {
		this.using = using;
	}
	public int getTokenId() {
		return tokenId;
	}
	public static int getUnusedTokenId() throws ExAllTokenUsed {
		for(Token t : Token.values()) {
			if(!t.isUsing())
				return t.tokenId;
		}
		throw new ExAllTokenUsed();
		
	}
	
}
