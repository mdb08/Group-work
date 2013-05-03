import java.util.Random;

public class TestUnitElectricity {

	public static void main(String[] args)
	{
		Monopoly mp = new Monopoly(2,1);
		Random r = new Random();
		Monopoly.die = r.nextInt(5) +1;
		System.out.println("Die=" + Monopoly.die);

		System.out.println("Scenario: Player lands on unowned Electricity Unit.");
		((UnitElectricity)(Board.tiles[Board.electricityNum])).checkTile(mp.players[0]);

		System.out.println("\nScenario: Player lands on owned Electricity Unit.");
		((UnitElectricity)(Board.tiles[Board.electricityNum])).owner = mp.players[1];
		((UnitElectricity)(Board.tiles[Board.electricityNum])).checkTile(mp.players[0]);

		System.out.println("\nScenario: Getting rent form Electricity Unit if owner doesn't own Fuel Unit.");
		((UnitElectricity)(Board.tiles[Board.electricityNum])).owner = mp.players[1];
		System.out.println("Rent is " + ((UnitElectricity)(Board.tiles[Board.electricityNum])).getRent());

		System.out.println("\nScenario: Getting rent form Electricity Unit if owner also owns Fuel Unit.");
		((UnitFuel)(Board.tiles[Board.fuelNum])).owner = mp.players[1];
		System.out.println("Rent is " + ((UnitElectricity)(Board.tiles[Board.electricityNum])).getRent());
	}
}