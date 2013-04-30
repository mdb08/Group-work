public class UnitCoincidence extends Tile{

	public UnitCoincidence(String name)	
	{
		this.name = name;
		this.tileID = Board.COINCIDENCE_NUM;
	}
	
	void checkTile(Player currentPlayer)
	{
		Card.draw(Board.coinCards[0], currentPlayer);
		CardCoincidence.cycleCards(Board.coinCards);
	}
	
	public static final String[] text = {"You won in a car race £100.",
	"You buy a kid an ice-cream. Pay £3.",
	"It's strange, but you found £1,000 on your backseat.",
	"Your car needs to be repared. Pay £485",
	"Car insurance. Pay £350."};

	public static final int[] amount ={+100,
		-3,
		+1000,
		-485,
		-350};
}
