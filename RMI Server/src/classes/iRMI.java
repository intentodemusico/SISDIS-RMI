package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.bson.Document;

public interface iRMI extends Remote {

    public Noticias createNoticias(String nombre, String titular, String contenido, String autor) throws RemoteException;

    public void createDBObjectNotices(Noticias noticias) throws RemoteException;

    public void updateNoticias(String autor,int id, String contenido) throws RemoteException;

    public void removeNoticias(String autor,int id) throws RemoteException ;

    public String readNoticias() throws RemoteException;

}
