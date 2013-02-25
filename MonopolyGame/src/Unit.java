public class Unit extends Tile{
	
	int cash;			//cash is added to the player's balance - fees are thus negative numbers
	
	public static final int CASH_LAUNCH = 200;
	public static final int CASH_FUEL = -200;
	public static final int CASH_ELECTRICITY = -75;
	public static final float FUEL_PERCENTAGE = 0.1f;
	
	void checkTile(Player currentPlayer)
	{
		if (this.name.equals("Fuel Unit"))
		{
			System.out.println((currentPlayer.worth*FUEL_PERCENTAGE) + " worth");	//DEBUG
			if ((currentPlayer.worth*FUEL_PERCENTAGE)<-this.cash)
			{
				currentPlayer.money -= (currentPlayer.worth*FUEL_PERCENTAGE);
			}
			else
			{
				currentPlayer.money += this.cash;
			}
		}
		else
		{
			currentPlayer.money += this.cash;
		}
	}
	
	public Unit(String name){
		this.name = name;
		if (name.equals("Launch Unit"))
		{
			cash = CASH_LAUNCH;
		}
		else if (name.equals("Fuel Unit"))
		{
			cash = CASH_FUEL;
		}
		else if (name.equals("Electricity Unit"))
		{
			cash = CASH_ELECTRICITY;
		}
	}

}
