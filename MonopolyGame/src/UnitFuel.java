public class UnitFuel extends Tile{

	/**
	 * @directed true
	 */
	
	int cash;			//cash is added to the player's balance - fees are thus negative numbers
	int cost;
	
	/**
	 * @clientCardinality 0..1
	 * @supplierCardinality 0..1
	 */
	
	Player owner;

	public static final float RENT_FACTOR = 4;
	public static final float RENT_FACTOR_PACK = 10;

	void checkTile(Player currentPlayer)
	{
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

	public int getRent()
	{
		int rent;
		if (this.owner == ((UnitElectricity)Board.tiles[Board.electricityNum]).owner)
		{
			rent = (int)RENT_FACTOR_PACK*Monopoly.die;
		}
		else
		{
			rent = (int)RENT_FACTOR*Monopoly.die;
		}
		return rent;
	}

	public UnitFuel(String name){
		this.name = name;		
	}
}