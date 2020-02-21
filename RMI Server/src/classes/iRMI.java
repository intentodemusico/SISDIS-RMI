package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iRMI extends Remote {

	public int sumar(int a) throws RemoteException;

}