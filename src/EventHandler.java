
public class EventHandler {
	public static void askingForEvent(Board board) {
		System.out.println("Do any player want to trade or do other things? (type help for list of command, end to exit)");
		String cmd = GameMaster.getYesNoCmd();
		if(cmd.equals("N")) 
			return;
		if(cmd.equals("Y")) {
			System.out.print("Enter Command:");
			String[] eventCmd = GameMaster.getPlayerCmd();
			while(!eventCmd[0].equals("end")) {
				if(eventCmd[0].equals("help")) {
					EventHandler.help();
				}
				else if(eventCmd[0].equals("ls")) {
					EventHandler.list(board);
				}else if(eventCmd[0].equals("trade")) {
					EventHandler.trade(board);
				}
				eventCmd = GameMaster.getPlayerCmd();
			}
		}
			
	}

	private static void help() {
		System.out.println("Current Command:");
		System.out.println("1. ls  (Show the player info)");
		
		
	}

	private static void list( Board board) {
		board.outputPlayer();
	}
	
	private static void trade(Board board) {
		board.outputPlayer();
	}
}
