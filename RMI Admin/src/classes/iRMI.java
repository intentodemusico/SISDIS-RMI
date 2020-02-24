package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface iRMI extends Remote {

    public void createDBObjectNotices(Noticias noticias) throws RemoteException;

    public void updateNoticias(int id, String contenido) throws RemoteException;

    public void removeNoticias(int id) throws RemoteException;

    public String readNoticias() throws RemoteException;

}
