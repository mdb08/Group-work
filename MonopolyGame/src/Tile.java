public class Tile {

	int tileID;
	String name;
	
	//TODO: Find a nicer way to handle checkTile, through polymorphism
	void checkTile(Player currentPlayer)
	{
		if (this instanceof Unit)
		{
			((Unit)this).checkTile(currentPlayer);
		}
		else if (this instanceof Property)
		{
			((Property)this).checkTile(currentPlayer);
		}
	}
}
