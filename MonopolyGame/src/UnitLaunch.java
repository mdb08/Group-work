public class UnitLaunch extends Tile{
	
	int cash;			//cash is added to the player's balance - fees are thus negative numbers
	
	public static final int CASH_LAUNCH = 200;
	
	void checkTile(Player currentPlayer)
	{
		currentPlayer.updateMoney(this.cash);
	}
	
	public UnitLaunch(String name){
		this.name = name;
		cash = CASH_LAUNCH;		
	}
}