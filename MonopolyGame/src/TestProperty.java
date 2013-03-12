import java.util.Random;

public class TestProperty {

	public static void main(String[] args)
	{
		Random random = new Random();
		Property property = new Property();
		Monopoly game = new Monopoly(2, random.nextInt(10000));
		property.checkTile(game.players[random.nextInt(2)]);
	}
}
