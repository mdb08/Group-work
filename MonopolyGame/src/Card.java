public class Card {

	public static final int NUM_OF_COINCIDENCE = 5;
	public static final int NUM_OF_PROVIDENCE = 5;
	String text;

	//called when a player draws a card
	static public void draw(Card card, Player player)
	{
		card.printText();
		card.execute(player);
	}

	public void printText()
	{
		System.out.println("The card reads: " + this.text);
	}
	
	public void execute(Player player)
	{
		if (!(this instanceof Card))
		{
			this.execute(player);
		}
	}
}
