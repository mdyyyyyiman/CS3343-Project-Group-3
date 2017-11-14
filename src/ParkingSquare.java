public class ParkingSquare extends Square {

	public ParkingSquare(String name) {
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
