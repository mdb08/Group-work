public class Monopoly {

	private Board lnkBoard;

	Player[] players;

	void playGame()
	{
		startGame();
		for (int i=0; i<TestMonopoly.NUM_OF_ROUNDS; i++)
		{
			System.out.println("\n");
			playRound();
		}
	}

	void playRound()
	{
		for (int i=0; i<TestMonopoly.NUM_OF_PLAYERS;i++)
		{
			Player currentPlayer = players[i];
			int die = currentPlayer.roll();
			System.out.println(currentPlayer.name + " rolls " + die + ".");
			currentPlayer.lnkCar.lnkUnit = Board.units[(currentPlayer.lnkCar.lnkUnit.unitID+die)%Board.NUM_OF_UNITS];
			System.out.println(currentPlayer.name + " lands on " + currentPlayer.lnkCar.lnkUnit.name + ".");
		}
	}

	void startGame()
	{
		System.out.println("Welcome to another exciting game of Monopoly Bored Game.");
	}

	public Monopoly(int numPlayers, int numRounds)
	{
		Board board = new Board();
		players = new Player[numPlayers];
		for (int i=0; i<numPlayers; i++)
		{
			players[i] = new Player();
			players[i].name = Player.plauerNamePool[i];
		}
		playGame();
	}
}
