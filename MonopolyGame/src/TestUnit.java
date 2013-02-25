public class TestUnit {	//pun unavoidable
	
	public static void main(String[] args)
	{
		Unit unit = new Unit("Test Unit");
		Board board = new Board();
		Player player = new Player();
		unit.checkTile(player);
	}
}