public class Tile {

	int tileID;
	String name;
	
	void checkTile(Player currentPlayer)
	{
		if (!(this instanceof Tile))
		{			
			this.checkTile(currentPlayer);
		}
	}
}
