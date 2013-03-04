public class TestBoard {
	
	public static void main(String args[])
	{
		Board board = new Board();
		System.out.println("Created board with " + Board.NUM_OF_UNITS + " tiles. Here they are: ");
		System.out.println("[TileID]:[Tile Name]\n");
		for (int i=0; i<Board.NUM_OF_UNITS; i++)
		{
			System.out.println(board.tiles[i].tileID + ": " + board.tiles[i].name);
		}
	}

}
