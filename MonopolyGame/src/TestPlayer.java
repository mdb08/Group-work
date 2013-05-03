public class TestPlayer {

	//other methods have been tested elsewhere
	public static void main(String[] args)
	{
		Board board = new Board();
		System.out.println("Scenario: Creating new player.");
		Player player = new Player();
		System.out.println("Created new Player with " + player.money + " money and " + player.worth + " worth.");
		
		System.out.println("\nScenario: Player rolls the die: " + player.roll());

		System.out.println("\nScenario: Player passes the Launch tile, with money=" + player.money);
		player.passedLaunch();
		System.out.println("Player just passed the Launch tile.  Money: " + player.money);

		System.out.println("\nScenario: Adding 100 to player's money manually.  Money before: " + player.money);
		player.updateMoney(100);
		
		System.out.println("The player's worth has been updated.  Money: " + player.money + ", Worth: " + player.worth);
		System.out.println(player.worth);
	}
}