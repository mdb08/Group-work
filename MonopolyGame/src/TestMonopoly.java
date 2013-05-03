public class TestMonopoly {

	public static void main(String[] args) {
		int numPlayers = 2;
		int numRounds = 1;
		for (int i=0; i<10; i++)
		{
			for (int j=0; j<100; j++)
			{
				System.out.println("Scenario: Creating a new Monopoly object with number of Players: " + i + " and number of Rounds: " + j);
				Monopoly monopoly = new Monopoly(i, j);			
			}
		}
		Monopoly monopoly = new Monopoly(numPlayers, numRounds);
		System.out.println("\n Scenario: Starting the game:");
		monopoly.startGame();
		System.out.println("\n Scenario: Playing a round:");
		monopoly.playRound();
	}
}