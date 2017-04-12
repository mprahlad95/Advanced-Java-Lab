import java.rmi.*;
import java.rmi.server.*;
import java.lang.*;
public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf
{
	public AddServerImpl() throws RemoteException
		{	
		}
	public double add(double d1, double d2) throws RemoteException
		{
		return d1+d2;
		}
	public double subtract(double d1, double d2) throws RemoteException
		{
		return d1-d2;
		}
	public double multiply(double d1, double d2) throws RemoteException
		{
		return d1*d2;
		}
	public double divide(double d1, double d2) throws RemoteException
		{
		return d1/d2;
		}
	public double cos(double d1) throws RemoteException
		{
		double x = d1;
		x = Math.toRadians(x);
		return Math.cos(x);
		}
	public double sin(double d1) throws RemoteException
		{
		double x = d1;
		x = Math.toRadians(x);
		return Math.sin(x);
		}
}