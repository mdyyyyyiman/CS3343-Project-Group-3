public class ChanceSquare extends Square {

	public ChanceSquare(String name) {
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
