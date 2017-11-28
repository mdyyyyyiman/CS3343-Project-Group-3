package Monopoly;

public class Main {
	public static void main(String[] args) {
		GameMaster gm = GameMaster.getInstance();
		Monopoly game = gm.initGame();
		game.startGame();
		gm.close();
	}
}
