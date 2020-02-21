package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.bson.Document;

public interface iRMI extends Remote {

    public Noticias createNoticias() throws RemoteException;

    public Usuarios createUsuarios() throws RemoteException;

    public Document createDBObjectNotices(Noticias noticias);

    public Document createDBObjectUsers(Usuarios usuarios); 
    public Noticias updateNoticias() throws RemoteException;
    public Noticias removeNoticias() throws RemoteException;
    public Noticias readNoticias() throws RemoteException;

}
