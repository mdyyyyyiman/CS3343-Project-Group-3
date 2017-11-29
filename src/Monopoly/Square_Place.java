package Monopoly;

public class Square_Place extends Square {
	private int price;
	private int owner = -1;
	private String colour;
	private Boolean house = false;
	private Boolean hotel = false;
	
	public Square_Place(String colour, String name, String price) {
		super(name);
		this.price = Integer.parseInt(price);
		this.colour = colour;
	}
	
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public void doAction(Player player, Board board) {
		if(owner < 0){
			
			System.out.println(player.getName() + ", do you want to buy it? (Y/N)");
			String cmd="";
			if(!player.isBot()) {
				cmd =GameMaster.getYesNoCmd();
			}else
				cmd = "Y";
			
			if(cmd.equals("Y")){
				System.out.println(player.getName() + " buy " + getName() + " for " + price);
				owner = player.getID();
				player.getMoney().substractMoney(price);
				player.buyLand(this);
				System.out.println(player.getName() + " now have $" + player.getMoney().getMoney() + " left.");
			}else if(cmd.equals("N"))
				System.out.println(player.getName() + " don't want to buy " + getDetails());

		}else{
			if(owner != player.getID()){
				int lost = price * 70 / 100;
				if(hotel) 
					lost *= 2;
				else if(house)
					lost *=1.5;
				System.out.println(player.getName() + " lost " + lost + " money to " + board.getPlayer(owner).getName());
				player.getMoney().substractMoney(lost);
				
				board.getPlayer(owner).getMoney().addMoney(lost);
				System.out.println(player.getName() + " now have $" + player.getMoney().getMoney() + " left.");
			}else {
				if(!hotel && house) {
					System.out.println("Do you want to build a hotel ($100)? (Y/N)");
					String cmd = GameMaster.getYesNoCmd();
					if(cmd.equals("Y")){
						System.out.println(player.getName() + " build a hotel on " + getName());
						house = true;
						player.getMoney().substractMoney(50);
					}else if(cmd.equals("N"))
						System.out.println(player.getName() + " don't want to build a hotel on  " + getName());
					
					
				}else if(!house) {
					System.out.println("Do you want to build a house ($50)? (Y/N)");
					String cmd = GameMaster.getYesNoCmd();
					if(cmd.equals("Y")){
						System.out.println(player.getName() + " build a house on " + getName());
						house = true;
						player.getMoney().substractMoney(50);
					}else if(cmd.equals("N"))
						System.out.println(player.getName() + " don't want to build a house on  " + getName());
				}
			}
			
		}
	}

	@Override
	public String getDetails() {
		return name + " " + colour +" ($" + price+")";
	}
}
