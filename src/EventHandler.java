
public class EventHandler {
	public static void askingForEvent(Board board) {
		System.out.println("Do any player want to trade or do other things? ");
		String cmd = cmdHandler.getYesNoCmd();
		if(cmd.equals("N")) 
			return;
		if(cmd.equals("Y")) {
			System.out.println("Enter Command:");
			String[] eventCmd = cmdHandler.getPlayerCmd();
			while(!eventCmd[0].equals("end")) {
				if(eventCmd[0].equals("help")) {
					EventHandler.help();
				}
				else if(eventCmd[0].equals("ls")) {
					EventHandler.list(board);
				}
				eventCmd = cmdHandler.getPlayerCmd();
			}
		}
			
	}

	private static void help() {
		System.out.println("Current Command:");
		System.out.println("1. ls 'player_name (Show the player info)");
		
		
	}

	private static void list( Board board) {
		board.outputPlayer();
	}
}
