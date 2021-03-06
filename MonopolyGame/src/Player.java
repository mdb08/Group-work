import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

	/**
	 * @clientCardinality 1
	 * @directed true
	 * @supplierCardinality 1
	 */

	static final int initMoney = 1500;

	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1
	 */

	Car lnkCar;

	/**
	 * @clientCardinality 1
	 * @supplierCardinality 1
	 */

	Die lnkDie;

	static final String[] playerNamePool = { "audi", "benz", "bmw", "porsche",
		"saab", "vw" };
	static final String[] playerNamePoolX = { "batmobile", "delorean", "lorry" };

	int money;
	int worth; //worth = card value + money
	int turn; //might need it to calculate rounds in Jail
	String name;
	boolean isInJail;
	int turnsInJail;

	public void payRent(Tile tile) {
		int rent;
		if (tile instanceof Property) {
			rent = ((Property) tile).getRent();
			((Property) tile).owner.updateMoney(rent);
			this.updateMoney(-rent);
			System.out.println(this.name + " pays �"
					+ rent + " rent to "
					+ ((Property) tile).owner.name);
		} else if (tile instanceof UnitElectricity) {
			rent = ((UnitElectricity) tile).getRent();
			((UnitElectricity) tile).owner.updateMoney(rent);
			this.updateMoney(-rent);
			System.out.println(this.name + " pays �"
					+ rent + " rent to "
					+ ((UnitElectricity) tile).owner.name);
		} else if (tile instanceof UnitFuel) {
			rent = ((UnitFuel) tile).getRent();
			((UnitFuel) tile).owner.updateMoney(rent);
			this.updateMoney(-rent);
			System.out.println(this.name + " pays �"
					+ rent + " rent to "
					+ ((UnitFuel) tile).owner.name);
		} else {
			System.out.println("You can't purchase " + tile.name);
		}
	}

	public void purchase(Tile tile)
	{
		System.out.println("Do you want to buy " + tile.name + "? (y/n)");
		String s=null;
		try{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			s = bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		if (s.equals("y"))
		{
			if (tile instanceof Property)
			{
				((Property) tile).owner = this;
				this.updateMoney(-((Property)tile).cost);
				System.out.println(this.name + " buys " + tile.name + " for �" + ((Property)tile).cost);
			}
			else if (tile instanceof UnitElectricity)
			{
				((UnitElectricity) tile).owner = this;
				this.updateMoney(-((UnitElectricity)tile).cost);
				System.out.println(this.name + " buys " + tile.name + " for �" + ((UnitElectricity)tile).cost);
			}
			else if (tile instanceof UnitFuel)
			{
				((UnitFuel) tile).owner = this;
				this.updateMoney(-((UnitFuel)tile).cost);
				System.out.println(this.name + " buys " + tile.name + " for �" + ((UnitFuel)tile).cost);
			}
			else
			{
				System.out.println("You can't purchase " + tile.name);
			}
		}
		else
		{
			System.out.println("Chose not to purchase the property.");
		}

	}

	public int roll() {
		int die = this.lnkDie.roll();
		return die;
	}

	public void passedLaunch() {
		this.updateMoney(UnitLaunch.CASH_LAUNCH);
	}

	public void updateProperty() {
		//TODO: Update property
		this.updateWorth();
	}

	public void updateMoney(int cash) {
		this.money += cash;
		this.updateWorth();
	}

	public void updateWorth() {
		this.worth = this.money; //TODO: Add property value to money to calculate the worth
	}

	public void sendToJail()
	{
		this.lnkCar.lnkTile = Board.tiles[Board.JAIL_NUM];
		this.isInJail = true;
		System.out.println(this.name + " is sent to Jail!");
		this.inJail();
	}

	public void inJail()
	{
		//Bailing out
		System.out.println("Do you want to pay �50 to get out of jail? (y/n)");
		String s=null;
		try{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			s = bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		if (s.equals("y"))
		{
			this.updateMoney(-UnitJail.BAIL_OUT_COST);
			System.out.println(this.name + " pays �" + UnitJail.BAIL_OUT_COST + " to get out of jail.");
			this.getOutOfJail();
		}
		//Rolling the die
		else
		{
			Monopoly.die = this.roll();
			if (Monopoly.die==UnitJail.EXIT_NUM)
			{
				System.out.println(this.name + " rolled " + UnitJail.EXIT_NUM + " and got out of jail");
				this.getOutOfJail();
			}
			else
			{
				System.out.println(this.name + " rolled " + Monopoly.die + " and failed to get out of jail.");
			}
		}
		if (this.isInJail)
		{
			this.turnsInJail++;
		}
		if (this.turnsInJail==UnitJail.MAX_TURNS_IN_JAIL)
		{
			this.updateMoney(-UnitJail.BAIL_OUT_COST);
			System.out.println(this.name + " is forced to pay �" + UnitJail.BAIL_OUT_COST + " to get out of jail.");
			this.getOutOfJail();
		}
	}

	public void getOutOfJail()
	{
		this.isInJail = false;
		this.turnsInJail = 0;
		Monopoly.playTurn(this);
	}

	public void moveToTile(Tile newTile, boolean checkLaunch)
	{
		//update tiles
		Tile oldTile = Board.tiles[this.lnkCar.lnkTile.tileID];
		this.lnkCar.lnkTile = newTile;
		System.out.println(this.name + " lands on " + this.lnkCar.lnkTile.name + ".");

		if (checkLaunch)
		{
			//Check if passed Launch
			if (oldTile.tileID>newTile.tileID && newTile.tileID!=Board.LAUNCH_NUM)
			{
				this.passedLaunch();
			}
		}

	}

	public Player() {
		lnkCar = new Car();
		lnkDie = new Die();
		isInJail = false;
		money = initMoney;
		worth = money;
		turn = 0;
		lnkCar.lnkTile = Board.tiles[0]; //Start at Launch
	}
}
