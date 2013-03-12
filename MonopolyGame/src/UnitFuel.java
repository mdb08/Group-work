public class UnitFuel extends Tile{

	int cash;			//cash is added to the player's balance - fees are thus negative numbers
	int cost = 200;
	int rentModifier;
	Player owner;

	public static final int CASH_FUEL = -200;
	public static final float FUEL_PERCENTAGE = 0.1f;
	public static final float RENT_FACTOR = 4;
	public static final float RENT_FACTOR_PACK = 10;

	void checkTile(Player currentPlayer)
	{
		//System.out.println((currentPlayer.worth*FUEL_PERCENTAGE) + " worth");	//DEBUG
		if ((currentPlayer.worth*FUEL_PERCENTAGE)<-CASH_FUEL)
		{
			cash = (int)(-currentPlayer.worth*FUEL_PERCENTAGE);
		}
		else
		{
			cash = CASH_FUEL;
		}
		currentPlayer.updateMoney(this.cash);
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
		if (this.owner == ((UnitElectricity)Board.tiles[Board.ELECTRICITY_NUM]).owner)
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
		cash = CASH_FUEL;
		rentModifier = 4;
	}
}