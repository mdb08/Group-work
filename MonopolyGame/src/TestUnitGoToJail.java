public class TestUnitGoToJail {

	public static void main(String[] args) {
		System.out.println("Scenario: A player lands on \"Go To Jail\".\n");
		Monopoly mp = new Monopoly(2, 1);
		UnitGoToJail gtj = new UnitGoToJail("Goto Jail.");
		gtj.checkTile(mp.players[0]);
	}
}