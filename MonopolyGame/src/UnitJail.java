public class UnitJail extends Tile{
	
	public static final int MAX_TURNS_IN_JAIL = 3;
	public static final int BAIL_OUT_COST = 50;
	public static final int EXIT_NUM = 6;
	
	public UnitJail(String name)	
	{
		this.name = name;
		this.tileID = Board.JAIL_NUM;
	}
	void checkTile(Player currentPlayer)
	{
		if (currentPlayer.isInJail)
		{
			System.out.println("Turns in jail:" + currentPlayer.turnsInJail);
			currentPlayer.inJail();
		}
		else
		{
			System.out.println(currentPlayer.name + " is only visiting in Jail");
		}
	}

}
