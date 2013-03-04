public class TestUnitElectricity {
	
	public static void main(String[] args)
	{
		UnitElectricity ue = new UnitElectricity("Electricity Unit Test");
		System.out.println("Created new Electricity Unit with name=" + ue.name + " and fee=" + -ue.cash);
		Board board = new Board();
		Player player = new Player();
		System.out.println("A player has " + player.money + " money before the Electricity Unit.");
		ue.checkTile(player);
		System.out.println("The player now has " + player.money + " money left.");
	}

}
