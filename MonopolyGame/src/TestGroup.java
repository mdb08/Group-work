public class TestGroup {
	
	public static void main(String args[])
	{
		String str = "Green";
		Group g = new Group(str);
		
		System.out.println("Scenario: Creating a green group.");
		
		System.out.println("GroupColor: " + g.groupColour);
		System.out.println("Groupname: " + g.groupName);
	}
}