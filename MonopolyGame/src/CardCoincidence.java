//Random player monetary reward/fee
public class CardCoincidence extends Card{

	int amount;		//displays the amount by which the player's cash must change
	
	public CardCoincidence(String text, int amount)
	{
		this.text = text;
		this.amount = amount;
	}
	
	public void execute(Player player)
	{
		player.updateMoney(this.amount);
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