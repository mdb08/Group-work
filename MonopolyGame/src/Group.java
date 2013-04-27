import java.awt.Color;
import java.lang.reflect.Field;

public class Group {

	Color groupColour;
	String groupName;
	
	private Group(Color colour)
	{
		this.groupColour = colour;
	}
	
	public Group(String str)
	{
		this(getColour(str));
		this.groupName = str;
	}
	
	public static Color getColour(String str)
	{
		Color colour = null;
		try {
		    Field field = Color.class.getField(str.toLowerCase());
		    colour = (Color)field.get(null);
		} catch (Exception e) {
		    colour = null; // Not defined
		}
		return colour;
	}
}