public class Player {

	static final int initMoney=1500;
	Car lnkCar;
	Die lnkDie;
	
	static final String[] playerNamePool = {"audi", "benz", "bmw", "porsche", "saab", "vw"};
	static final String[] playerNamePoolX = {"batmobile", "delorean", "lorry"};
	private Property lnkProperty;
	int money;
	int worth;			//worth = card value + money
	int turn;			//might need it to calculate rounds in Jail
	String name;
	
	public int roll()
	{
		int die = this.lnkDie.roll();
		return die;
	}
	
	public void passedLaunch()
	{
		this.money += Unit.CASH_LAUNCH;
	}
	
	public void updateWorth()
	{
		this.worth = this.money;			//TODO: Add property value to money to calculate the worth
	}
	
	public Player() {
		lnkCar = new Car(name);
		lnkDie = new Die();
		money = initMoney;
		worth = money;
		turn = 0;
		lnkCar.lnkTile = Board.tiles[0];	//Start at Launch
	}
}
