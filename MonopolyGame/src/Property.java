public class Property extends Tile{

	private Tile lnkTile;
	private Group lnkGroup;
	public Player owner;
	int rent;
	int cost;
	
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
