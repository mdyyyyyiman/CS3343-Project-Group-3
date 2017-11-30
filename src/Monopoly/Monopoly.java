package Monopoly;

public class Monopoly {
	private String gameMode;
	private Die die = new Die();
	private Board board;

	public Monopoly(Player[] players, String gameMode) {
		this.board = new Board(players);
		this.gameMode = gameMode;
		//board.outputBoard();
		//board.outputPlayer();
	}

	public void startGame() {
		System.out.println("Game start!");
		System.out.println("============================");
		while (!isGameEnd() && !board.hasWinner()) {
			Player currentPlayer = board.getCurrentPlayer();
			if (!currentPlayer.isBrokeOut()) {
				System.out.println(currentPlayer.getDetails());
		
				int face1 = currentPlayer.tossDie(die);
				int face2 = currentPlayer.tossDie(die);
				
				if(currentPlayer.isInJail()) {
					if(face1 ==face2) {
						System.out.println("Player is in Jail, and get the same faces.");
						board.movePlayer(currentPlayer, face1+face2);
					}else
						System.out.println("Player is in Jail, and dont get the same faces. Can't move.");
				}
				board.movePlayer(currentPlayer, face1+face2);
			}else {
				System.out.println("Player "+currentPlayer.getID()+" is Broke out. ");
			}
			board.nextTurn();
			System.out.println("========");
		}
		System.out.println("========");
		if (board.hasWinner()) {
			System.out.println(board.getWinner().getName() + " is won by don't brokeout!");
		} else {
			System.out.println(board.getMaxMoneyPlayer().getName() + " is won by have most money!");
		}
		System.out.println("Game over!");
	}

	public boolean isGameEnd() {
		for (Player player : board.getPlayers()) {
			if (player.getTotalWalk() < 20) {
				return false;
			}
		}
		return true;
	}
}
