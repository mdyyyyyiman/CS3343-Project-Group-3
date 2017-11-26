package Monopoly;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameMaster {
	private static GameMaster instance;
	private static Scanner Ascanner= new Scanner(System.in);
	
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
		File file = new File("playerInit.txt");
		try {
			Scanner scanner = new Scanner(file);
			totalPlayer = scanner.nextInt();
			System.out.println("totalPlayer:"+totalPlayer);
			
			if(totalPlayer > 2 || totalPlayer < 8 ) {
				players = new Player[totalPlayer];
				for(int i = 0 ; i< totalPlayer;i++) {
					String name  = scanner.next();
					int tokenId = scanner.nextInt();
					if(tokenId < 0 || tokenId > 8) {
						System.out.println("The Token number is not correct for " + name);
						throw new ExUnknownToken();
					}
					System.out.println("Player "+(i+1)+" :" +name + "("+Token.values()[tokenId]+")");
					players[i] = new Player(i, name, Token.values()[tokenId]);
					
				}
			}
			if (totalPlayer > 8) {
				System.err.println("Error: Invalid player count.");
			}
			 scanner.close();
			 return new Monopoly(players);
		}
		
		
		catch (FileNotFoundException e ) {
			e.printStackTrace();
		}
		catch(ExUnknownToken e) {
			System.err.println(e.getMessage());
		}
		finally {
			return new Monopoly(players);
		}
		
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
		return"N";

	}

	public static String[] getPlayerCmd() {
		String cmd = Ascanner.next();
		String[] cmdArray = cmd.split(" ");
		return cmdArray;
	}
	
	public void close() {
		Ascanner.close();
		
	}
}
