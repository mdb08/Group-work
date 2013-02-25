public class Board {

	final static int NUM_OF_UNITS = 24;	
	final static int LAUNCH_NUM = 0;
	final static int FUEL_NUM = 8;
	final static int ELECTRICITY_NUM = 20;
	
	static Tile[] tiles;
	
	public Board() {
		
		tiles = new Tile[NUM_OF_UNITS];

		//Tile instantiation
		for (int i=0; i<NUM_OF_UNITS; i++){
			//System.out.println(i);		//DEBUG
			//Launch Unit
			if (i==LAUNCH_NUM)
			{
				tiles[i] = new Unit("Launch Unit");
				tiles[i].name = "Launch Unit";
			}
			//Fuel Unit
			else if (i==FUEL_NUM)
			{
				tiles[i] = new Unit("Fuel Unit");
				tiles[i].name = "Fuel Unit";
			}
			//Electricity Unit
			else if (i==ELECTRICITY_NUM)
			{
				tiles[i] = new Unit("Electricity Unit");
				tiles[i].name = "Electricity Unit";
			}
			//Properties
			else
			{
				tiles[i] = new Property();
				tiles[i].name = "Unit" + i;
			}
			tiles[i].tileID = i;
		}
	}
}
