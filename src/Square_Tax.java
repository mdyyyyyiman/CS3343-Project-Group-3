public class Square_Tax extends Square {
	private int price;
	public Square_Tax(String name, String price) {
		super(name);
		this.price = Integer.parseInt(price);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		System.out.println(player.getName() + " need to pay $" + price + " tax." );
		player.getMoney().substractMoney(price);
	}

	@Override
	public String getDetails() {
		return name + " " + price;
	}
}
