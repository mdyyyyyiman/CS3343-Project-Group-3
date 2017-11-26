package Monopoly;
public class Square_Parking extends Square {

	public Square_Parking(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		System.out.println("Nothing Happen.");
	}

	@Override
	public String getDetails() {
		return name;
	}
}
