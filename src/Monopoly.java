import java.util.Scanner;

public class Monopoly {
	Die die = new Die();
	Board board;

	public Monopoly(Player[] players) {
		board = new Board(players);
		//board.outputBoard();
		//board.outputPlayer();
	}

	public static void main(String[] args) {
		System.out.println("\tMonopoly\n");
		Scanner scanner = new Scanner(System.in);
		int totalPlayer = 0;
		Player[] players = null;
		while (totalPlayer < 2 || totalPlayer > 8) {
			try {
				System.out.println("How many people are playing?");
				System.out.print("Players (2 - 8): ");
				totalPlayer = scanner.nextInt();
				int i = 0;
				players = new Player[totalPlayer];
				while (i != totalPlayer) {

					System.out.println("\nWhat is Player " + (i + 1) + " name and chess? (Enter the number) ");
					for(Token token : Token.values()) {
						System.out.print( "(" +token.getTokenId()+")"+token+" ");
					}
					System.out.println();
					scanner.nextLine();
					String name  = scanner.next();
					int tokenId = scanner.nextInt();
					if(tokenId < 0 || tokenId > 8) {
						System.out.println("The Chess number is not correct plz re-enter the info.");
						continue;
					}
					players[i] = new Player(i + 1, name, Token.values()[tokenId]);
					i++;

				}
			} catch (Exception e) {
				System.err.println("Error: Number too large.");
				continue;
			}
			if (totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
			}
		}
		scanner.close();
		Monopoly game = new Monopoly(players);
		// game.startGame();
	}

	public void startGame() {
		System.out.println("Game start!");
		System.out.println("========");
		while (!isGameEnd() && !board.hasWinner()) {
			if (!board.getCurrentPlayer().isBrokeOut()) {
				int face = board.getCurrentPlayer().tossDie(die);
				board.movePlayer(board.getCurrentPlayer(), face);
			}
			board.nextTurn();
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
