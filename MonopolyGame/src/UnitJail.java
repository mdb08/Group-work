public class UnitJail extends Tile{
	
	public static final int MAX_TURNS_IN_JAIL = 3;
	public static final int BAIL_OUT_COST = 50;
	public static final int EXIT_NUM = 6;
	
	public UnitJail(String name)	
	{
		this.name = name;
	}
	void checkTile(Player currentPlayer)
	{
		if (currentPlayer.isInJail)
		{
			currentPlayer.inJail();
		}
		//add "A is visiting B at the Jail. Harharhar"
	}

}
