public class UnitProvidence extends Tile{

	public UnitProvidence(String name)
	{
		this.name = name;
		this.tileID = Board.PROVIDENCE_NUM;
	}
	
	void checkTile(Player currentPlayer)
	{
		Card.draw(Board.provCards[0], currentPlayer);
		CardProvidence.cycleCards(Board.provCards);
	}
	
	public static final String[] text = {"Take a step back and admire your car. No, literally.",
		"You haven't been paying your taxes. Go to jail.",
		"Nitro! Move 10 tiles forward.",
		"Strange glowing 'reset' button on your wheel. Go to Launch, and collect the Launch money.",
		"Bouncing: Move forward to Launch, but you're not allowed any money because of cheating - you get knocked back two tiles."};

	public static final Tile[] destination = {null,
		Board.tiles[Board.JAIL_NUM],
		null,
		Board.tiles[Board.LAUNCH_NUM],
		Board.tiles[Board.LAUNCH_NUM]};
	
	public static final int[] distance = {-1,
		0,
		+10,
		0,
		-2};
	
	public static final boolean[] checkLaunch = {true,
		false,
		true,
		true,
		false};
}