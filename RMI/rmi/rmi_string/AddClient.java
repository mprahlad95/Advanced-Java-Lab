import java.rmi.*;
	public class AddClient {
		public static void main(String args[]) {
		try	{
			String addServerURL = "rmi://" + args[0] + "/AddServer";
			AddServerIntf addServerIntf =(AddServerIntf)Naming.lookup(addServerURL);
			System.out.println("First string is: " + args[1]);
			String s1 = String.valueOf(args[1]);
			System.out.println("Second string is: " + args[2]);
			String s2 = String.valueOf(args[2]);
			System.out.println("Concatenation: " + addServerIntf.concatString(s1, s2));	
			System.out.println("Length 1: " + addServerIntf.lengthString(s1));
			System.out.println("Length 2: " + addServerIntf.lengthString(s2));	
			System.out.println("Uppercase: " + addServerIntf.upperCaseString(s1));	
			System.out.println("Lowercase: " + addServerIntf.lowerCaseString(s2));	
			System.out.println("Are Equal? " + addServerIntf.compareString(s1, s2));	
					
			}
		catch(Exception e)
		{
			System.out.println("Exception: " + e);
		}
	}
}
