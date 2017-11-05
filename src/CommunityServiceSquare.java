public class CommunityServiceSquare extends Square {
	public CommunityServiceSquare(String name) {
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
