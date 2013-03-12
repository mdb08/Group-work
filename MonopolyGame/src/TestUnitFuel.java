public class TestUnitFuel {

	public static void main(String[] args)
	{
		String name = "Test Fuel Unit";
		UnitFuel uf = new UnitFuel(name);
		System.out.println("Created new Fuel Unit with name=" + name);
		Board board = new Board();
		Player player = new Player();
		System.out.println("Some scenarios of a player with starting money=3000 getting onto the Fuel Unit:");
		player.money = 3000;
		player.updateWorth();
		for (int i=0; i<100; i++)
		{
			System.out.print("\nBefore: Money=" + player.money + ", Worth=" + player.worth);
			uf.checkTile(player);
			System.out.print(" || After: Money=" + player.money + " , Worth=" + player.worth + " || Fee=" + -uf.cash);			
		}
	}

}