public class TestUnitLaunch {

	public static void main(String[] args)
	{
		UnitLaunch ul = new UnitLaunch("Test Launch Unit");
		System.out.println("Created a new Launch Unit with name=" + ul.name
				+ " and cash reward=" + ul.cash);
		Board board = new Board();
		Player player = new Player();
		System.out.println("A new player's cash after hitting the Launch Unit:");
		for (int i=0; i<50; i++)
		{
			ul.checkTile(player);
			System.out.println("Turn " + i + ": New money=" + player.money);
		}
	}
}
