public class TaxSquare extends Square {
	private int price;
	public TaxSquare(String name, String price) {
		super(name);
		this.price = Integer.parseInt(price);
	}
	
	@Override
	public void doAction(Player player, Board board) {
		
	}

	@Override
	public String getDetails() {
		return name + " " + price;
	}
}
