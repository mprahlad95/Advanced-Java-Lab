import java.rmi.*;
	public class AddClient {
		public static void main(String args[]) {
		try	{
			String addServerURL = "rmi://" + args[0] + "/AddServer";
			AddServerIntf addServerIntf =(AddServerIntf)Naming.lookup(addServerURL);
			System.out.println("First number is: " + args[1]);
			double d1 = Double.valueOf(args[1]).doubleValue();
			System.out.println("Second number is: " + args[2]);
			double d2 = Double.valueOf(args[2]).doubleValue();
			System.out.println("Sum: " + addServerIntf.add(d1, d2));	
			System.out.println("Difference: " + addServerIntf.subtract(d1, d2));
			System.out.println("Product: " + addServerIntf.multiply(d1, d2));
			System.out.println("Quotient: " + addServerIntf.divide(d1, d2));
			System.out.println("Sin of first number: " + addServerIntf.sin(d1));
			System.out.println("Sin of second number: " + addServerIntf.sin(d2));
			System.out.println("Cosine of first number: " + addServerIntf.cos(d1));
			System.out.println("Cosine of second number: " + addServerIntf.cos(d2));
			}
		catch(Exception e)
		{
			System.out.println("Exception: " + e);
		}
	}
}
