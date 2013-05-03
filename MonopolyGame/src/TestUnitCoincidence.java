public class TestUnitCoincidence {
	
	public static void main(String[] args)
	{
		Monopoly mp = new Monopoly(2, 1);
		UnitCoincidence uc = new UnitCoincidence("TestUnit Coincidence");
		System.out.println("Scenario: " + Monopoly.players[0].name + " lands on Providence Unit two times.\n");
		uc.checkTile(Monopoly.players[0]);
		uc.checkTile(Monopoly.players[0]);
	}
}