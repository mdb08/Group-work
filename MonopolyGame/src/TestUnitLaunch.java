public class TestUnitLaunch {

	public static void main(String[] args)
	{
		System.out.println("Scenario: Player lands two times on the Launch Unit.\n");
		UnitLaunch ul = new UnitLaunch("Launch Unit");
		Board board = new Board();
		Player player = new Player();
		System.out.println("Player's money before landing on the Launch Unit:" + player.money);
		System.out.println("Player's cash after hitting the Launch Unit:");
		for (int i=0; i<2; i++)
		{
			ul.checkTile(player);
			System.out.println("Turn " + i + ": New money=" + player.money);
		}
	}
}
