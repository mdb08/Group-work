public class TestPlayer {

	public static void main(String[] args)
	{
		Board board = new Board();
		Player player = new Player();
		player.roll();
		player.passedLaunch();
		player.updateWorth();
		System.out.println(player.worth);
	}
}