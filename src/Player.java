import java.util.ArrayList;

public class Player {
	int totalWalk = 0;
	int position = 0;
	int id;
	String name;
	Token token;
	boolean brokeout = false;
	Money money = new Money(1500);
	boolean jailPass = false;
	boolean inJail = false;
	ArrayList<Square_Place> ownedLand = new ArrayList<Square_Place>();
	
	public boolean hasJailPass() {
		return jailPass;
	}

	public void setJailPass(boolean jailPass) {
		this.jailPass = jailPass;
	}

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
		System.out.println(getName() + " toss a die... Face is " + face1);
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
	public void buyLand(Square_Place place) {
		ownedLand.add(place);
	}

	public ArrayList<Square_Place> getOwnedLand() {
		return ownedLand;
	}
	public void goJail(boolean b) {
		inJail =b;
	}
	public boolean isInJail() {
		return inJail;
	}
	
}
