public class Board {

	final static int NUM_OF_UNITS = 24;
	static Unit[] units;
	
	public Board() {
		
		units = new Unit[NUM_OF_UNITS];
		units[0] = new Unit();
		units[0].name = "Launch";
		units[0].unitID = 0;
		for (int i=1; i<NUM_OF_UNITS; i++){
			units[i] = new Unit();
			units[i].name = "Unit" + i;
			units[i].unitID = i;
		}
	}
}
