import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnitAirport extends Tile{
	
	public UnitAirport(String name)
	{
		this.name = name;
		this.tileID = Board.AIRPORT_NUM;
	}

	void checkTile(Player currentPlayer)
	{
		System.out.println("To which occupied tile would you like to go? Please give the number shown next to it (anything else to cancel:");
		
		//get occupied Tiles
		Tile[] occupiedTiles = new Tile[Monopoly.numPlayers-1];
		int counter=0;
		for (int i=0; i<Monopoly.numPlayers; i++)
		{
			if (Monopoly.players[i]!=currentPlayer)
			{
				occupiedTiles[counter] = Monopoly.players[i].lnkCar.lnkTile;
				counter++;
			}
		}
		//display the occupied tiles
		for (int i=0; i<occupiedTiles.length; i++)
		{
			System.out.println(i + ": " + occupiedTiles[i].name);
		}
		
		//read input
		int choice;
		try{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(bufferRead.readLine());
			System.out.println("The manager, the designer and the programmer of Monopoly Bored Game wish you a pleasant flight to " + occupiedTiles[choice].name);
			currentPlayer.moveToTile(occupiedTiles[choice], false);
		}
		catch(IOException e)
		{
			System.out.println("Cancelled flight. Maybe next time you should buy Last Minute tickets.");
		}
		catch (NumberFormatException nfo)
		{
			System.out.println("Cancelled flight. If you prefer travelling by an " + currentPlayer.name + " car, so be it.");
		}
		
		
	}
}
