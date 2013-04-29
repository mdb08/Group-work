import java.awt.Color;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Board {

	/**
	 * @clientCardinality 1
	 * @directed true
	 * @supplierCardinality 24
	 */

	final static int NUM_OF_UNITS = 24;	
	final static int NUM_OF_GROUPS = 9;
	final static int LAUNCH_NUM = 0;
	final static int JAIL_NUM = 6;
	final static int GOTOJAIL_NUM = 18;
	public static int fuelNum;
	public static int electricityNum;
	private final static String FILENAME= "properties.xml";





	/**
	 * @clientCardinality 1
	 * @supplierCardinality 24
	 */

	static Tile[] tiles;
	static Group[] groups;

	public Board()
	{

		tiles = new Tile[NUM_OF_UNITS];
		groups = new Group[NUM_OF_GROUPS];

		//Filling array with dummies
		for (int i=0; i<tiles.length; i++)
		{
			tiles[i] = new Tile();
			tiles[i].tileID = i;
		}
		tiles[LAUNCH_NUM] = new UnitLaunch("Launch Unit");
		tiles[JAIL_NUM] = new UnitJail("Jail");
		tiles[GOTOJAIL_NUM] = new UnitGoToJail("Goto Jail");

		//Writing mask-data to array
		readFromFile(FILENAME);
	}

	public void readFromFile(String filename)
	{
		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			//StringBuffer elementValue = new StringBuffer(512);

			DefaultHandler handler = new DefaultHandler() {

				boolean bProperty = false;
				boolean bName = false;
				boolean bPosition = false;
				boolean bPrice = false;
				boolean bRent = false;
				boolean bGroup = false;

				//to recognise Power Units
				boolean isPowerUnit = false;

				String name;
				int position;
				int price;
				int rent;
				String group;

				public void startElement(String uri, String localName,String qName, 
						Attributes attributes) throws SAXException {

					if (qName.equalsIgnoreCase("property")) {
						bProperty = true;
					}
					if (qName.equalsIgnoreCase("name")) {
						bName = true;
					}

					if (qName.equalsIgnoreCase("position")) {
						bPosition = true;
					}

					if (qName.equalsIgnoreCase("price")) {
						bPrice = true;
					}

					if (qName.equalsIgnoreCase("rent")) {
						bRent = true;
					}

					if (qName.equalsIgnoreCase("group")) {
						bGroup = true;
					}
				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					//Creating the elements
					if(qName.equals("property")){
						if(isPowerUnit)
						{
							//Fuel Unit
							if (name.equals("Fuel"))
							{
								tiles[position] = new UnitFuel("Fuel Unit");
								((UnitFuel)tiles[position]).cost = price;
								Board.fuelNum = position;
							}
							//Electricity Unit
							else if (name.equals("Electricity"))
							{
								tiles[position] = new UnitElectricity("Electricity Unit");
								((UnitElectricity)tiles[position]).cost = price;
								Board.electricityNum = position;
							}
							isPowerUnit = false;
						}
						//Properties
						else
						{
							tiles[position] = new Property();
							((Property)tiles[position]).name = name;
							((Property)tiles[position]).rent = rent;
							((Property)tiles[position]).cost = price;
							((Property)tiles[position]).lnkGroup = checkGroup(group);
						}
						tiles[position].tileID = position;
						bProperty = false;
					}
					if (qName.equalsIgnoreCase("name")) {
						bName = false;
					}

					if (qName.equalsIgnoreCase("position")) {
						bPosition = false;
					}

					if (qName.equalsIgnoreCase("price")) {
						bPrice = false;
					}

					if (qName.equalsIgnoreCase("rent")) {
						bRent = false;
					}

					if (qName.equalsIgnoreCase("group")) {
						bGroup = false;
					}
				}

				//checks if Group exists - if not, creates one and adds it to array
				private Group checkGroup(String str) {
					Group group = new Group(str);
					boolean exists = false;
					int position = -1;
					for (int i=0; i<groups.length; i++)
					{
						if (groups[i]==null)
						{
							exists = false;
							position = i;
							break;
						}
						else if (groups[i].groupName.equals(group.groupName))
						{
							//System.out.println("DEBUG: found matching group @ " + i);
							exists = true;
							group = groups[i];
							break;
						}
					}
					if (!exists)
					{
						//System.out.println("DEBUG: New group added: " + group.groupName);
						groups[position] = group;
					}
					return group;
				}

				public void characters(char ch[], int start, int length) throws SAXException {
					if (bName) {
						name = new String(ch, start, length);
					}
					if (bPosition) {
						position = Integer.parseInt(new String(ch, start, length));
					}
					if (bPrice) {
						price = Integer.parseInt(new String(ch, start, length));
					}
					if (bRent) {
						rent = Integer.parseInt(new String(ch, start, length));
					}
					if (bGroup) {
						group = new String(ch, start, length);
						if (group.equals("Power"))
						{
							isPowerUnit = true;
						}
					}
				}
			};

			saxParser.parse(filename, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}