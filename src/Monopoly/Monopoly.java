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
		System.out.println("========");
		while (!isGameEnd() && !board.hasWinner()) {
			if (!board.getCurrentPlayer().isBrokeOut()) {
				Util.print(board.getCurrentPlayer(),"");				
				int face1 = board.getCurrentPlayer().tossDie(die);
				int face2 = board.getCurrentPlayer().tossDie(die);
				if(board.getCurrentPlayer().isInJail()) {
					if(face1 ==face2) {
						System.out.println("Player is in Jail, and get the same faces.");
						board.movePlayer(board.getCurrentPlayer(), face1+face2);
					}else
						System.out.println("Player is in Jail, and dont get the same faces. Can't move.");
				}
				board.movePlayer(board.getCurrentPlayer(), face1+face2);
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
