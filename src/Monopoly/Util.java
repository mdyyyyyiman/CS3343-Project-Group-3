package Monopoly;
public class Util {
	public static void print(Player player, String msg) {
		System.out.println("["+player.getName() +"'s Turn " + (player.getTotalWalk() + 1) + "] [Square: " + player.getCurrentPosition() + "] [$" + player.getMoney().getMoney() + "] " + msg);
	}
}
