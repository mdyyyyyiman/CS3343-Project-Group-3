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

					System.out.println("\nWhat is Player " + (i + 1) + " name and token? (Enter the number) ");
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
					players[i] = new Player(i, name, Token.values()[tokenId]);
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
		
		Monopoly game = new Monopoly(players);
		game.startGame();
		scanner.close();
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
