public class UnitGoToJail extends Tile{

	public UnitGoToJail(String name)	
	{
		this.name = name;
		this.tileID = Board.GOTOJAIL_NUM;
	}
	
	void checkTile(Player currentPlayer)
	{
		currentPlayer.sendToJail();
	}
}