import java.util.Scanner;

public class GameMaster {
	private static GameMaster instance;
	private static Scanner scanner= new Scanner(System.in);
	
	public static GameMaster getInstance() {
		if(instance == null) {
	         instance = new GameMaster();
	      }
		return instance;
	}
	private GameMaster() {}
	
	public Monopoly initGame() {
		System.out.println("\tMonopoly\n");
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
		
		return new Monopoly(players);
	}
	
	
	public static String getYesNoCmd() {
//		while(true){
//			String cmd = scanner.next();
//			if(cmd.toUpperCase().equals("Y")){
//				return "Y";
//			}else if(cmd.toUpperCase().equals("N")){
//				return "N";
//			}else {
//				System.out.println("Incorrect Command, Please re-enter !");
//			}
//		}
		return"Y";

	}

	public static String[] getPlayerCmd() {
		String cmd = scanner.next();
		String[] cmdArray = cmd.split(" ");
		return cmdArray;
	}
	
	public void close() {
		scanner.close();
		
	}
}
