public class Square_GoToJail extends Square {
	public Square_GoToJail(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		System.out.print(player.getName() + " has go to Jail.");
		int JailSquare = board.getJailSquare();
		if(JailSquare == -1) {
			System.out.println("Error in board, jail not found, game goes on.");
		}else{
			board.movePlayer(player, JailSquare, false);
		}
	}

	@Override
	public String getDetails() {

		return name;
	}
}
