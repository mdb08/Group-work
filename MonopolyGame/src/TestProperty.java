import java.util.Random;

public class TestProperty {

	public static void main(String[] args)
	{
		Random random = new Random();
		Property property = new Property();
		Monopoly game = new Monopoly(2, 1);
		
		System.out.println("Scenario: A player lands on an empty tile.\n");
		property = (Property)Board.tiles[2];
		property.checkTile(game.players[random.nextInt(2)]);
		
		System.out.println("\nScenario: A player lands on an owned tile.\n");
		property.owner = game.players[1];
		property.checkTile(game.players[0]);
		
		System.out.println("\nScenario: The rent is calculated for a tile whose owner doesn't own the whole group.");
		System.out.println(property.getRent());
		
		System.out.println("\nScenario: The rent is calculated for a tile whose owner owns the whole group.");
		((Property)Board.tiles[1]).owner = game.players[1];
		System.out.println(property.getRent());
	}
}