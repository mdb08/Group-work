public class TestDie {

	private final static int NUM_OF_ROLLS = 100;
	private static int result;
	private static int sum;
	public static void main(String[] args) {
		Die die = new Die();
		System.out.println("Created a new six-sided die. Here are " + NUM_OF_ROLLS + " random rolls:");
		for (int i=1; i<=NUM_OF_ROLLS; i++){
			result = die.roll();
			sum +=result;
			System.out.println("Roll No." + i + ": " + result);
		}
		System.out.println("Average of the rolls is: " + (sum/(float)NUM_OF_ROLLS));
	}
}