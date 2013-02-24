public class Player {

	Car lnkCar;
	Die lnkDie;
	
	static final String[] plauerNamePool = {"audi", "benz", "bmw", "porsche", "saab", "vw"};
	static final String[] playerNamePoolX = {"batmobile", "delorean", "lorry"};
	private Property lnkProperty;
	int money;
	int turn;
	String name;
	
	public int roll()
	{
		int die = this.lnkDie.roll();
		return die;
	}
	
	public Player() {
		lnkCar = new Car(name);
		lnkDie = new Die();
		turn = 0;
		lnkCar.lnkUnit = Board.units[0];	//Start at Launch
	}
}
