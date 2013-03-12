import java.util.Random;

public class TestProperty {

	public static void main(String[] args)
	{
		Random random = new Random();
		for (int i=0; i<100; i++)
		{
			Property property = new Property(random.nextInt(100000));
			System.out.println("Created Property " + property.name 
					+ ", Cost: " + property.cost + ", Rent: " + property.rent);
		}
		Board board = new Board();
		Player player = new Player();
		//property.checkTile(player);	//TODO: test checkTile
	}
}
