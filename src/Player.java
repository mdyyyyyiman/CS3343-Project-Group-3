public class Player {
	int totalWalk = 0;
	int position = 0;
	int id;
	String name;
	Token token;
	boolean brokeout = false;
	Money money = new Money(5000);
	
	public Player(int id, String name, Token token) {
		this.id = id;
		this.name = name;
		this.token = token;
	}
	
	public int getTotalWalk() {
		return totalWalk;
	}
	
	public int tossDie(Die die) {
		int face1 = die.getFace();
		int face2 = die.getFace();
		
		Util.print(this, getName() + " toss a die... Face is " + face1);
		return face1;
	}
	
	public int getCurrentPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public void nextTurn() {
		totalWalk++;
	}
	
	public String getName() {
		return name;
	}
	
	public Money getMoney() {
		return money;
	}
	
	public int getID() {
		return id;
	}
	
	public void setBrokeOut(boolean brokeout) {
		this.brokeout = brokeout;
	}
	
	public boolean isBrokeOut() {
		return brokeout;
	}

	public Token getToken() {
		
		return token;
	}
}
