public class UnitFuel extends Tile{

	int cash;			//cash is added to the player's balance - fees are thus negative numbers

	public static final int CASH_FUEL = -200;
	public static final float FUEL_PERCENTAGE = 0.1f;

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
	}

	public UnitFuel(String name){
		this.name = name;		
		cash = CASH_FUEL;
	}
}