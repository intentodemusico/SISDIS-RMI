package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.bson.Document;

public interface iRMI extends Remote {

    public Noticias createNoticias(String nombre, String titular, String contenido) throws RemoteException;

    public void createDBObjectNotices(Noticias noticias)throws RemoteException;

    public void updateNoticias(int id, String contenido) throws RemoteException;

    public void removeNoticias(int id) throws RemoteException ;

    public void readNoticias() throws RemoteException;

}
