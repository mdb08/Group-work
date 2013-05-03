import java.util.Random;

public class TestUnitAirport {
	
	public static void main(String[] args)
	{
		System.out.println("Scenario: Landing on Airport tile (four players in game).\n");
		Monopoly mp = new Monopoly(4,1);
		Random r = new Random();
		//mp.players[0].lnkCar.lnkTile = Board.tiles[Board.JAIL_NUM];
		mp.players[1].lnkCar.lnkTile = Board.tiles[r.nextInt(Board.NUM_OF_UNITS)];
		mp.players[2].lnkCar.lnkTile = Board.tiles[r.nextInt(Board.NUM_OF_UNITS)];
		mp.players[3].lnkCar.lnkTile = Board.tiles[r.nextInt(Board.NUM_OF_UNITS)];
		Board.tiles[Board.AIRPORT_NUM].checkTile(mp.players[0]);
	}
}