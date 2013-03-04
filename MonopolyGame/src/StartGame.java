import java.io.*;

public class StartGame {

	final static int NUM_OF_PLAYERS=2;
	final static int NUM_OF_ROUNDS=20;

	private static int numPlayers;
	private static int numRounds;

	public static void main(String args[]){
		init();
		Monopoly monopoly = new Monopoly(numPlayers, numRounds);
		monopoly.playGame();
	}

	private static void init()
	{
		numPlayers = NUM_OF_PLAYERS;
		numRounds = NUM_OF_ROUNDS;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = null;
		boolean exception  = false;		

		//Read number of players
		do 
		{
			System.out.print("Please enter the number of players: ");
			try {
				num = br.readLine();
				numPlayers = Integer.parseInt(num);
				if (numPlayers<Monopoly.MIN_PLAYERS || numPlayers>Monopoly.MAX_PLAYERS)
				{
					System.out.println("Sorry, the number of players must be between " 
							+ Monopoly.MIN_PLAYERS + " and " + Monopoly.MAX_PLAYERS);
					throw new NumberFormatException();
				}
				exception = false;
			} catch (IOException e) {
				System.out.println("IO error!");
				System.exit(1);
				exception = true;
			}
			catch (NumberFormatException nfo)
			{
				System.out.println("Please enter a positive integer and press Enter");
				exception = true;
			}
		} while (exception);


		//Read number of rounds
		do
		{
			System.out.print("Please enter the number of rounds to play: ");
			try {
				num = br.readLine();
				numRounds = Integer.parseInt(num);
				if (numRounds<=0)
				{
					throw new NumberFormatException("Expected positive integer");
				}
				exception = false;
			} catch (IOException e) {
				System.out.println("IO error!");
				System.exit(1);
				exception = true;
			}
			catch (NumberFormatException nfo)
			{
				System.out.println("Please enter a positive integer and press Enter");
				exception = true;
			}
		} while (exception);


	}	
}