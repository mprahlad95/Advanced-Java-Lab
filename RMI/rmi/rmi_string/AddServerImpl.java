import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;
public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf
{
	public AddServerImpl() throws RemoteException
		{	
		}
	public 	String concatString(String s1, String s2)
		{
		String s3 = s1+ s2;
		return s3;
		}
	public int lengthString(String s)
		{
		int x = s.length();
		return x;
		}
	public String upperCaseString(String s)
		{
		return s.toUpperCase();
		}
	public String lowerCaseString(String s)
		{
		return s.toLowerCase();
		}
	
	public int compareString(String s1, String s2)
		{
		int result = s1.compareTo( s2 );
		return result;
		}
}