public class Property extends Tile {

	/**
	 * @clientCardinality 2
	 * @directed true
	 * @supplierCardinality 1
	 */
	
	public static final int GROUP_MODIFIER = 2;		//if whole group is owned, rent becomes rent*GROUP_MODIFIER
	Group lnkGroup;
	
	/**
	 * @clientCardinality 0..*
	 * @supplierCardinality 0..1
	 */
	
	public Player owner;
	int rent;
	int cost;

	void checkTile(Player currentPlayer) {
		//Thread.dumpStack();		//DEBUG
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
	
	public int getRent()
	{
		int rentToPay=0;
		Group[] groups = Board.groups;
		Tile[] tiles = Board.tiles;
		int propertiesInGroup = 0;
		int ownedPropertiesInGroup = 0;
		boolean hasWholeGroup = false;
		for (int i=0; i<tiles.length; i++)
		{
			if ((tiles[i] instanceof Property) && ((Property)tiles[i]).lnkGroup.equals(this.lnkGroup))
			{
				propertiesInGroup++;
				if ((this.owner!=null) && (((Property)tiles[i]).owner!=null)
					&& (((Property)tiles[i]).owner.equals(this.owner)))
				{
					ownedPropertiesInGroup++;
				}
			}
		}
		//System.out.println("DEBUG: Owned properties: " + ownedPropertiesInGroup + ", Overall: " + propertiesInGroup);
		if (propertiesInGroup==ownedPropertiesInGroup)
		{
			hasWholeGroup = true;
			//System.out.println("DEBUG: Owner owns the whole property group.");
		}
		if (hasWholeGroup)
		{
			rentToPay = Property.GROUP_MODIFIER * rent;
		}
		else
		{
			rentToPay = rent;
		}
		return rentToPay;
	}
}
