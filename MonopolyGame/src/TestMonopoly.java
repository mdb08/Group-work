public class TestMonopoly {

	public static void main(String[] args) {
		int numPlayers = 2;
		int numRounds = 20;
		for (int i=0; i<10; i++)
		{
			for (int j=0; j<100; j++)
			{
				System.out.println("Creating a new Monopoly object with number of Players: " + i + " and number of Rounds: " + j);
				Monopoly monopoly = new Monopoly(i, j);			
			}
		}
		Monopoly monopoly = new Monopoly(numPlayers, numRounds);
		System.out.println("\nStarting the game:");
		monopoly.startGame();
		System.out.println("\nPlaying a game:");
		monopoly.playGame();
		System.out.println("\nPlaying a round:");
		monopoly.playRound();
		System.out.println("\nEnding a game:");
		monopoly.endGame();
	}
}