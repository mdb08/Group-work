//Teleports the player
public class CardProvidence extends Card{

	Tile destination;
	int distance;		//how many tiles the player gets teleported
	boolean checkLaunch;	//True if Launch should be checked during teleport

	public CardProvidence(String text, Tile destination, int distance, boolean checkLaunch)
	{
		this.text = text;
		this.destination = destination;
		this.distance = distance;
		this.checkLaunch = checkLaunch;
	}

	public void execute(Player player)
	{
		if (destination!=null)
		{
			player.moveToTile(destination, checkLaunch);
		}
		if (distance!=0)
		{
			Tile newTile = Board.tiles[(Board.NUM_OF_UNITS+player.lnkCar.lnkTile.tileID + distance)%Board.NUM_OF_UNITS];
			player.moveToTile(newTile, checkLaunch);
		}
	}
	
	public static void cycleCards(Card[] cards)	//puts the top card (index=0) on the bottom of the stack
	{
		Card tmp = cards[0];
		for (int i=1; i<cards.length; i++)
		{
			cards[i-1] = cards[i];
		}
		cards[cards.length-1] = tmp;
	}
}
