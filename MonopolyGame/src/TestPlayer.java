public class TestPlayer {

	public static void main(String[] args)
	{
		Board board = new Board();
		System.out.println("Creating new player");
		Player player = new Player();
		System.out.println("Created new Player with " + player.money + " money and " + player.worth + " worth.");
		int tmp = player.roll();
		System.out.println("Player rolls the die: " + tmp);
		player.passedLaunch();
		System.out.println("Player just passed the Launch tile.  Money: " + player.money + ", Worth: " + player.worth);
		player.money += 100;
		System.out.println("Added 100 to player's money manually.  Money: " + player.money + ", Worth: " + player.worth);
		player.updateWorth();
		System.out.println("The player's worth has been updated.  Money: " + player.money + ", Worth: " + player.worth);
		System.out.println(player.worth);
	}
}