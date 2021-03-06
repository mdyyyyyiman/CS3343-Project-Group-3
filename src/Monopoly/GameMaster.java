package Monopoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameMaster {
	private static GameMaster instance;
	private static Scanner cmdScanner = new Scanner(System.in);
	private String gameMode;
	private static ArrayList<Token> tokenBox = new ArrayList<>();

	public static GameMaster getInstance() {
		if (instance == null) {
			instance = new GameMaster();
		}
		return instance;
	}

	private GameMaster() {
		this.gameMode = "single";
		for (Token t : Token.values()) {
			this.tokenBox.add(t);
		}
	}

	public Monopoly initGame() {
		Player[] players = null;
		int totalPlayer = 0;

		System.out.println(" _______ _______ _______ _______ ______ _______ _____  ___ ___ \r\n"
				+ "|   |   |       |    |  |       |   __ \\       |     ||   |   |\r\n"
				+ "|       |   -   |       |   -   |    __/   -   |       \\     / \r\n"
				+ "|__|_|__|_______|__|____|_______|___|  |_______|_______||___|  \r\n"
				+ "                                                               ");
		System.out.println("Welcome to the Monopoly Game ! I am the game master of this game.\n"
				+ "Now, please choose the mode that you want to play with. (Single/Multi)");

		gameMode = cmdScanner.nextLine();

		if (gameMode.equalsIgnoreCase("single")) {

		} else if (gameMode.equalsIgnoreCase("multi")) {

		} else {
			System.out.println("Unknow Game Mode, default to single.");
			gameMode = "single";
		}

		players = initPlayerWithCmd(gameMode);

		return new Monopoly(players, gameMode);

	}

	//

	public static Player[] initPlayerWithCmd(String gameMode) {
		int totalPlayer = 0;
		Player[] players = null;

		try {
			// getting the no of total player
			System.out.println("What is number of total Player(2-8)?");
			totalPlayer = cmdScanner.nextInt();
			if (totalPlayer < 2 || totalPlayer > 8) {
				System.out.println("Invalid Total Player. Default number of player to 4.");
				totalPlayer = 4;

			}
			players = new Player[totalPlayer];
			// setUp player according to different gamemode
			if (gameMode.equals("single")) {
				System.out.println("What is your name and token (1-8)?");
				String name = cmdScanner.next();
				int tokenId = cmdScanner.nextInt();
				if (tokenId < 0 || tokenId > 8) {
					System.out.println("The Token number is not correct for " + name);
					tokenId = Token.getUnusedTokenId();
					System.out.println("Reassign token : (" + Token.values()[tokenId] + ") for " + name);

				}
				if (Token.values()[tokenId].isUsing()) {
					System.out.println("There token has been used.");
					tokenId = Token.getUnusedTokenId();
				}
				players[0] = new Player(1, name, Token.values()[tokenId], false);
				for (int i = 1; i < totalPlayer; i++) {
					tokenId = Token.getUnusedTokenId();
					players[i] = new Player(i + 1, "bot " + (i + 1), Token.values()[tokenId], true);
				}

			} else {
				for (int i = 0; i < totalPlayer; i++) {
					System.out.println("Please enter Player " + (i + 1) + "'s name and Token (1-8).");
					String name = cmdScanner.next();
					int tokenId = cmdScanner.nextInt();
					if (tokenId < 0 || tokenId > 8) {
						System.out.println("The Token number is not correct for " + name);
						tokenId = Token.getUnusedTokenId();
						System.out.println("Reassign token : (" + Token.values()[tokenId] + ") for " + name);
					}
					if (Token.values()[tokenId].isUsing()) {
						System.out.println("There token has been used.");
						tokenId = Token.getUnusedTokenId();
					}
					players[i] = new Player(i + 1, name, Token.values()[tokenId], false);
				}
			}

			System.out.println("List of Player in this game");
			for (Player p : players) {
				System.out.println(p.toString());
			}
			return players;
		} catch (ExAllTokenUsed e) {
			System.err.println(e.getMessage());
		}
		return players;

	}

	public static String getYesNoCmd() {
		return getYesNoCmd(cmdScanner);
	}

	public static String getYesNoCmd(Scanner s) {
		while (true) {
			String cmd = s.next();
			if (cmd.toUpperCase().equals("Y")) {
				return "Y";
			} else if (cmd.toUpperCase().equals("N")) {
				return "N";
			} else {
				System.out.println("Incorrect Command, Please re-enter !");
			}
		}

	}

	// public static String[] getPlayerCmd() {
	// String cmd = cmdScanner.next();
	// String[] cmdArray = cmd.split(" ");
	// return cmdArray;
	// }

	public void close() {
		cmdScanner.close();

	}
}
