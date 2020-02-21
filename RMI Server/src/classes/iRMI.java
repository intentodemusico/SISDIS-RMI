package classes;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.bson.Document;

public interface iRMI extends Remote {

    public Noticias createNoticias(String nombre, String titular, String contenido) throws RemoteException;

    public Usuarios createUsuarios(String nombre,int rol) throws RemoteException;

    public void createDBObjectNotices(Noticias noticias);

    public void createDBObjectUsers(Usuarios usuarios); 
    public Noticias updateNoticias() throws RemoteException;
    public void removeNoticias() throws RemoteException;
    public void readNoticias() throws RemoteException;

}
