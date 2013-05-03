public class TestUnitJail {

	public static void main(String[] args)
	{
		Monopoly mp = new Monopoly(2, 1);
		UnitJail uj = new UnitJail("Jail");
		
		System.out.println("Scenario: A player is in Jail.");
		Monopoly.players[0].isInJail = true;
		uj.checkTile(Monopoly.players[0]);
		
		System.out.println("\nScenario: A player is visiting the Jail.");
		uj.checkTile(Monopoly.players[1]);
		
	}
}
