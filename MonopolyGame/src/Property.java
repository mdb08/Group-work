public class Property extends Tile {

	/**
	 * @clientCardinality 2
	 * @directed true
	 * @supplierCardinality 1
	 */
	
	private Group lnkGroup;
	
	/**
	 * @clientCardinality 0..*
	 * @supplierCardinality 0..1
	 */
	
	public Player owner;
	int rent;
	int cost;

	void checkTile(Player currentPlayer) {
		if (this.owner == null) {
			if (currentPlayer.money < this.cost) {
				System.out.println("Sorry, not enough money.");
			} else {
				currentPlayer.purchase(this);
			}
		} else if (this.owner != currentPlayer) {
			currentPlayer.payRent(this);
		}
	}
}
