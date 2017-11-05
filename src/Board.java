import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Board {
	int currentTurn = 0;
	int totalPlayer = 0;
	Player[] players;
	Square[] squares = new Square[40];
	String[] names = new String[] { "House", "Villa", "Town", "City", "Peace", "Village", "Jade", "Soi 4", "White", "Dark" };
	
	public Board(Player[] players) {
		this.players = players;
		File file = new File("MonopolyInit.txt");
		try {
			Scanner scanner = new Scanner(file);
			
			 while (scanner.hasNextLine()) {
				 String cmdLine = scanner.nextLine().trim();
				 if (cmdLine.equals(""))
						continue;
				 String[] cmdParts = cmdLine.split(" ");
				 if (cmdParts[1].equals("Go")) 
					 squares[Integer.parseInt(cmdParts[0])] = new GoSquare(cmdParts[1],cmdParts[2]);
				 else if(cmdParts[1].equals("Place")) 
					 squares[Integer.parseInt(cmdParts[0])] = new PlaceSquare(cmdParts[2],cmdParts[3],cmdParts[4]);
				 else if(cmdParts[1].equals("CommunityService")) 
					 squares[Integer.parseInt(cmdParts[0])] = new CommunityServiceSquare(cmdParts[1]);
				 else if(cmdParts[1].equals("Tax")) 
					 squares[Integer.parseInt(cmdParts[0])] = new TaxSquare(cmdParts[1],cmdParts[2]);
				 else if(cmdParts[1].equals("Chance")) 
					 squares[Integer.parseInt(cmdParts[0])] = new ChanceSquare(cmdParts[1]);
				 else if(cmdParts[1].equals("Jail")) 
					 squares[Integer.parseInt(cmdParts[0])] = new JailSquare(cmdParts[1]);
				 else if(cmdParts[1].equals("GoToJail")) 
					 squares[Integer.parseInt(cmdParts[0])] = new GoToJailSquare(cmdParts[1]);
				 else if(cmdParts[1].equals("Parking")) 
					 squares[Integer.parseInt(cmdParts[0])] = new ParkingSquare(cmdParts[1]);

		        }
			 scanner.close();
		}
		catch (FileNotFoundException e ) {
			e.printStackTrace();
		}
		
	}
	
	public Square movePlayer(Player player, int face) {
		return movePlayer(player, face, true);
	}
	
	public Square movePlayer(Player player, int face, boolean count) {
		if(player.isBrokeOut()){ return squares[player.getCurrentPosition()]; }
		int newPosition = normalizePosition(player.getCurrentPosition() + face);
		player.setPosition(newPosition);
		Util.print(player, player.getName() + " goes to " + squares[player.getCurrentPosition()].getName());
		squares[newPosition].doAction(player, this);
		if(player.getMoney().isBrokeOut()){
			Util.print(player, player.getName() + " has been broke out!");
			player.setBrokeOut(true);
		}else{
			if(count){
				player.nextTurn();
			}
		}
		return squares[newPosition];
	}
	
	public boolean hasWinner() {
		int ingame = 0;
		for(Player player:players){
			if(!player.isBrokeOut()){
				ingame++;
			}
		}
		return ingame <= 1;
	}
	
	public Player getWinner() {
		if(!hasWinner()){ return null; }
		for(Player player:players){
			if(!player.isBrokeOut()){ return player; }
		}
		return null;
	}
	
	public Player getMaxMoneyPlayer() {
		Player maxplayer = null;
		for(Player player:players){
			if(maxplayer == null || maxplayer.getMoney().getMoney() < player.getMoney().getMoney()){
				maxplayer = player;
			}
		}
		return maxplayer;
	}
	
	public int normalizePosition(int position) {
		return position % squares.length;
	}
	
	public Player getCurrentPlayer() {
		return players[currentTurn];
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void nextTurn() {
		if(++currentTurn >= players.length){
			currentTurn = 0;
		}
	}
	
	public Player getPlayer(int id) {
		return players[id];
	}
	
	public int getTotalSquare() {
		return squares.length;
	}
	public void outputBoard() {	
		for(int i =0; i < squares.length;i++) 
			System.out.println("The " + i + " square is a " + squares[i].getDetails());
	}
	public void outputPlayer() {
		for(Player p : players)
			System.out.println("Player " + p.getID() + " " + p.getName()+" "+p.getToken());
	}
}

