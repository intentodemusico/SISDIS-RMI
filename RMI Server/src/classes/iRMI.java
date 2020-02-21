package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.bson.Document;

public interface iRMI extends Remote {

    public Noticias createNoticias(String nombre, String titular, String contenido) throws RemoteException;

    public Usuarios createUsuarios(String nombre,int rol) throws RemoteException;

    public Document createDBObjectNotices(Noticias noticias);

    public Document createDBObjectUsers(Usuarios usuarios); 
    public Noticias updateNoticias() throws RemoteException;
    public Noticias removeNoticias() throws RemoteException;
    public Noticias readNoticias() throws RemoteException;

}
