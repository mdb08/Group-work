public class TestMonopoly {

	public static void main(String[] args) {
		int numPlayers = 2;
		int numRounds = 20;
		Monopoly monopoly = new Monopoly(numPlayers, numRounds);
		monopoly.startGame();
		monopoly.playRound();
		monopoly.playGame();
		monopoly.endGame();
	}
}