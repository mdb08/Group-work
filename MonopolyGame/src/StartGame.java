public class StartGame {
	
	final static int NUM_OF_PLAYERS=6;
	final static int NUM_OF_ROUNDS=20;
	
	public static void main(String args[]){
		Monopoly monopoly = new Monopoly(NUM_OF_PLAYERS, NUM_OF_ROUNDS);
		monopoly.startGame();
	}
}
