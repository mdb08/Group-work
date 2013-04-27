public class UnitGoToJail extends Tile{

	public UnitGoToJail(String name)	
	{
		this.name = name;
	}
	
	void checkTile(Player currentPlayer)
	{
		currentPlayer.sendToJail();
	}
}