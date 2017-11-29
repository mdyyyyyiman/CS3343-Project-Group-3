package Monopoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameMaster {
	private static GameMaster instance;
	private static Scanner cmdScanner = new Scanner(System.in);

	public static GameMaster getInstance() {
		if (instance == null) {
			instance = new GameMaster();
		}
		return instance;
	}

	private GameMaster() {
	}

	public Monopoly initGame() {
		Player[] players = null;
		int totalPlayer = 0;
		try {
			System.out.println("\tMonopoly\n");
			players = initPlayerWithFile();
			if (players == null) {
				System.out.println("What is number of total Player(2-8)?");
				totalPlayer = cmdScanner.nextInt();
				if (totalPlayer < 2 || totalPlayer > 8) {
					throw new ExInvalidTotalPlayer();
				}

				players = new Player[totalPlayer];
				for (int i = 0; i < totalPlayer; i++) {

					System.out.println("Please enter Player " + (i + 1) + "'s name and Token (1-8).");
					String name = cmdScanner.next();
					int tokenId = cmdScanner.nextInt();
					if (tokenId < 0 || tokenId > 8) {
						System.out.println("The Token number is not correct for " + name);
						throw new ExUnknownToken();
					}
					System.out.println("Player " + (i + 1) + " :" + name + "(" + Token.values()[tokenId] + ")");
					players[i] = new Player(i, name, Token.values()[tokenId]);

				}
			}
			return new Monopoly(players);
		} catch (ExInvalidTotalPlayer e) {
			System.err.println(e.getMessage());
		} catch (ExUnknownToken e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	public static String getYesNoCmd() {
		while (true) {
			String cmd = cmdScanner.next();
			if (cmd.toUpperCase().equals("Y")) {
				return "Y";
			} else if (cmd.toUpperCase().equals("N")) {
				return "N";
			} else {
				System.out.println("Incorrect Command, Please re-enter !");
			}
		}

	}

	public static Player[] initPlayerWithFile() throws ExInvalidTotalPlayer {
		int totalPlayer = 0;
		Player[] players = null;
		Scanner scanner = null;
		File file = new File("playerInit.txt");
		try {
			scanner = new Scanner(file);
			totalPlayer = scanner.nextInt();
			System.out.println("totalPlayer:" + totalPlayer);

			if (totalPlayer < 2 || totalPlayer > 8) {
				throw new ExInvalidTotalPlayer();
			}
			players = new Player[totalPlayer];
			for (int i = 0; i < totalPlayer; i++) {
				String name = scanner.next();
				int tokenId = scanner.nextInt();
				if (tokenId < 0 || tokenId > 8) {
					System.out.println("The Token number is not correct for " + name);
					throw new ExUnknownToken();
				}
				System.out.println("Player " + (i + 1) + " :" + name + "(" + Token.values()[tokenId] + ")");
				players[i] = new Player(i, name, Token.values()[tokenId]);

			}
			return players;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ExUnknownToken e) {
			System.err.println(e.getMessage());
		}finally{
			scanner.close();
		}

		return players;

	}

	public static String[] getPlayerCmd() {
		String cmd = cmdScanner.next();
		String[] cmdArray = cmd.split(" ");
		return cmdArray;
	}

	public void close() {
		cmdScanner.close();

	}
}
