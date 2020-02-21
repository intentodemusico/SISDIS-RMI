package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iRMI extends Remote {

	public Noticias createNoticias() throws RemoteException;
        public Usuarios createUsuarios() throws RemoteException;
        public Noticias updateNoticias() throws RemoteException;
        public Noticias removeNoticias() throws RemoteException;
        public Noticias readNoticias() throws RemoteException;

}