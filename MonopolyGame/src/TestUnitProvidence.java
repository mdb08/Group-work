public class TestUnitProvidence {

	public static void main(String[] args)
	{
		Monopoly mp = new Monopoly(2, 1);
		UnitProvidence up= new UnitProvidence("TestUnit Providence");
		System.out.println("Scenario: " + Monopoly.players[0].name + " lands on Providence Unit two times.\n");
		up.checkTile(Monopoly.players[0]);
		up.checkTile(Monopoly.players[0]);
	}
}
