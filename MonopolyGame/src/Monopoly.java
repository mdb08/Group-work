public class Monopoly {

	/**
	 * @clientCardinality 1
	 * @directed true
	 * @supplierCardinality 1
	 */

	private Board lnkBoard;

	/**
	 * @clientCardinality 1
	 * @supplierCardinality 2..4
	 */

	public static Player[] players;

	public static final int REPLAY_DIE=6;
	public static final int MIN_PLAYERS=2;
	public static final int MAX_PLAYERS=4;
	public static int numPlayers;
	public int numRounds;
	public static int die;
	public static Player currentPlayer;



	void playGame()
	{
		startGame();
		for (int i=0; i<this.numRounds; i++)
		{
			System.out.println("\n");
			playRound();
		}
		endGame();
	}

	void playRound()
	{
		for (int i=0; i<this.numPlayers;i++)
		{
			currentPlayer = players[i];
			playTurn(currentPlayer);
		}
	}

	static void playTurn(Player currentPlayer)
	{
		do {
			System.out.println("\n" + currentPlayer.name + "'s turn:");
			if (currentPlayer.isInJail)
			{
				currentPlayer.lnkCar.lnkTile.checkTile(currentPlayer);
			}
			else
			{				
				//Roll die
				die = currentPlayer.roll();
				System.out.println(currentPlayer.name + " rolls " + die + ".");

				//Update tile and check if passed Launch
				Tile newTile = Board.tiles[(currentPlayer.lnkCar.lnkTile.tileID+die)%Board.NUM_OF_UNITS];
				currentPlayer.moveToTile(newTile, true);
				
				//Check tile for any actions
				newTile.checkTile(currentPlayer);
			}
			System.out.println(currentPlayer.name + " has �" + currentPlayer.money + ".");
		} while (die==REPLAY_DIE);
	}

	void startGame()
	{
		System.out.println("Welcome to another exciting game of Monopoly Bored Game.");
	}

	void endGame()
	{
		//TODO: Implement something for the game end
	}

	public Monopoly(int numPlayers, int numRounds)
	{
		try
		{			
			Board board = new Board();
			players = new Player[numPlayers];
			this.numPlayers = numPlayers;
			this.numRounds = numRounds;
			for (int i=0; i<numPlayers; i++)
			{
				players[i] = new Player();
				players[i].name = Player.playerNamePool[i];
			}
		}
		catch (ArrayIndexOutOfBoundsException e)		//for the rare case that the MIN_PLAYER value is set to more players than player names exist.
		{
			System.out.println("Minimum Player numbers less than 0 and more than "	+ Player.playerNamePool.length 
					+ " will throw ArrayIndexOutOfBounds exceptions and should be avoided.");
		}

	}
}