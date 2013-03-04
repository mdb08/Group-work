public class UnitElectricity extends Tile{

	int cash;			//cash is added to the player's balance - fees are thus negative numbers

	public static final int CASH_ELECTRICITY = -75;

	void checkTile(Player currentPlayer)
	{
		currentPlayer.updateMoney(this.cash);
	}
	
	public UnitElectricity(String name){
		this.name = name;
		cash = CASH_ELECTRICITY;
	}

}