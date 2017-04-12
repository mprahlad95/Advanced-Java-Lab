import java.rmi.*;

public interface AddServerIntf extends Remote
{
	double add(double d1, double d2) throws RemoteException;
	double subtract(double d1, double d2) throws RemoteException;
	double multiply(double d1, double d2) throws RemoteException;
	double divide(double d1, double d2) throws RemoteException;
	double cos(double d1) throws RemoteException;
	double sin(double d1) throws RemoteException;
}