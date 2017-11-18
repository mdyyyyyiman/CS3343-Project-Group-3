import java.util.Random;

public class Square_CommunityService extends Square {
	
	public Square_CommunityService(String name) {
		super(name);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		Random random = new Random();
		int card = random.nextInt(1)+1;
		if(card == 1) {
			System.out.println("You have draw the Jail Pass");
			player.setJailPass(true);
		}else if(card == 2) {
			System.out.println("You have won the jackpot! Gain $300");
			player.getMoney().addMoney(300);
		}
	}

	@Override
	public String getDetails() {
		return name;
	}
}