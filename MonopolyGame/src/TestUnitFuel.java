import java.util.Random;

public class TestUnitFuel {

	public static void main(String[] args)
	{
		Monopoly mp = new Monopoly(2,1);
		Random r = new Random();
		Monopoly.die = r.nextInt(5) +1;
		System.out.println("Die=" + Monopoly.die);

		System.out.println("Scenario: Player lands on unowned Fuel Unit.");
		((UnitFuel)(Board.tiles[Board.fuelNum])).checkTile(mp.players[0]);

		System.out.println("\nScenario: Player lands on owned Fuel Unit.");
		((UnitFuel)(Board.tiles[Board.fuelNum])).owner = mp.players[1];
		((UnitFuel)(Board.tiles[Board.fuelNum])).checkTile(mp.players[0]);

		System.out.println("\nScenario: Getting rent from Fuel Unit if owner doesn't own Electricity Unit.n");
		((UnitFuel)(Board.tiles[Board.fuelNum])).owner = mp.players[1];
		System.out.println("Rent is " + ((UnitFuel)(Board.tiles[Board.fuelNum])).getRent());

		System.out.println("\nScenario: Getting rent from Fuel Unit if owner also owns Electricity Unit.");
		((UnitElectricity)(Board.tiles[Board.electricityNum])).owner = mp.players[1];
		System.out.println("Rent is " + ((UnitFuel)(Board.tiles[Board.fuelNum])).getRent());		
	}
}