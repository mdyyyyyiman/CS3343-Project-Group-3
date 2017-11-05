public class ParkingSquare extends Square {

	public ParkingSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		
	}

	@Override
	public String getDetails() {
		return name;
	}
}
