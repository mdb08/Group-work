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

	public void payRent(Tile tile) {
		if (tile instanceof Property) {
			((Property) tile).owner.updateMoney(((Property) tile).rent);
			this.updateMoney(-((Property) tile).rent);
			System.out.println(this.name + " pays £" + ((Property) tile).rent
					+ " rent to " + ((Property) tile).owner.name);
		} else if (tile instanceof UnitElectricity) {
			((UnitElectricity) tile).owner.updateMoney(((UnitElectricity) tile)
					.getRent());
			this.updateMoney(-((UnitElectricity) tile).getRent());
			System.out.println(this.name + " pays £"
					+ ((UnitElectricity) tile).getRent() + " rent to "
					+ ((UnitElectricity) tile).owner.name);
		} else if (tile instanceof UnitFuel) {
			((UnitFuel) tile).owner.updateMoney(((UnitFuel) tile).getRent());
			this.updateMoney(-((UnitFuel) tile).getRent());
			System.out.println(this.name + " pays £"
					+ ((UnitFuel) tile).getRent() + " rent to "
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
				System.out.println(this.name + " buys " + tile.name + " for £" + ((Property)tile).cost);
			}
			else if (tile instanceof UnitElectricity)
			{
				((UnitElectricity) tile).owner = this;
				this.updateMoney(-((UnitElectricity)tile).cost);
				System.out.println(this.name + " buys " + tile.name + " for £" + ((UnitElectricity)tile).cost);
			}
			else if (tile instanceof UnitFuel)
			{
				((UnitFuel) tile).owner = this;
				this.updateMoney(-((UnitFuel)tile).cost);
				System.out.println(this.name + " buys " + tile.name + " for £" + ((UnitFuel)tile).cost);
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

	public Player() {
		lnkCar = new Car();
		lnkDie = new Die();
		money = initMoney;
		worth = money;
		turn = 0;
		lnkCar.lnkTile = Board.tiles[0]; //Start at Launch
	}
}
