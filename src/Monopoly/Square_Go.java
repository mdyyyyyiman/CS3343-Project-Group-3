package Monopoly;
public class Square_Go extends Square {
	private int bonus;
	public Square_Go(String name, String bonus) {
		super(name);
		this.bonus = Integer.parseInt(bonus);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		System.out.println(player.getName() + " is at Go... Giving 1000 money");
		player.getMoney().addMoney(bonus);
	}

	@Override
	public String getDetails() {

		return name + " " + bonus;
	}
}
