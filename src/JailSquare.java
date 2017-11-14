public class JailSquare extends Square {
	public JailSquare(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		if(player.hasJailPass()) {
			System.out.println("Do you want to use Jail Pass ?");
			String cmd = cmdHandler.getYesNoCmd();
			if(cmd.equals("Y")){
				System.out.println("You have use the jail pass");
				player.setJailPass(false);
			}else if(cmd.equals("N")){
				System.out.println(player.getName() + " has been Jail and lost 500 money");
				player.getMoney().substractMoney(500);
				
			}
		}
		
	}

	@Override
	public String getDetails() {
		return name;
	}
}
