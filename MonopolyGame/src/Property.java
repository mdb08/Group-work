public class Property extends Tile{

	private Tile lnkTile;
	private Group lnkGroup;
	public Player owner;
	int rent;
	int cost;
	
	public Property(int index)
	{
		this.name = "Unit" + index;
		this.cost = 4 + 10*index;
		this.rent = 4*index;
	}
	
	void checkTile(Player currentPlayer){
		if (this.owner==null)
		{
			if (currentPlayer.money < this.cost)
			{
				System.out.println("Sorry, not enough money.");
			}
			else
			{
				currentPlayer.purchase(this);
			}
		}
		else if (this.owner!=currentPlayer)
		{
			currentPlayer.payRent(this);
		}
	}	
}
