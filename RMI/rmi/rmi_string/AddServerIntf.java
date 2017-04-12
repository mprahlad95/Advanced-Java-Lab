import java.rmi.*;

public interface AddServerIntf extends Remote
{
	String concatString(String s1, String s2) throws RemoteException;
	int lengthString(String s) throws RemoteException;
	String upperCaseString(String s) throws RemoteException;
	String lowerCaseString(String s) throws RemoteException;
	
	int compareString(String s1, String s2) throws RemoteException;
	
}