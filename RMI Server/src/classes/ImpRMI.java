package classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class ImpRMI extends UnicastRemoteObject implements iRMI {

    protected ImpRMI() throws RemoteException {
    }

    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see classes.iRMI#sumar(int, int)
     */
    @Override
    public Usuarios createUsuarios(String nombre,int rol) throws RemoteException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Usuarios u = new Usuarios();
        u.setNombre(nombre);
        u.setRole(rol);
        return u;

    }

    @Override
    public Noticias createNoticias(String nombre, String titular, String contenido ) throws RemoteException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Noticias u = new Noticias();
        //u.setId(1);
        u.setNombre(nombre);
        u.setTitular(titular);
        u.setContenido(contenido);
        return u;

    }
    @Override
    public Document createDBObjectNotices(Noticias noticias) {
        Document docBuilder = new Document();

        docBuilder.append("_id", noticias.getId());
        docBuilder.append("Nombre", noticias.getNombre());
        docBuilder.append("Titular", noticias.getTitular());
        docBuilder.append("Fecha", noticias.getFechaCreado());
        docBuilder.append("Fecha", noticias.getFechaEditado());
        docBuilder.append("AutorId", noticias.getAutorId());
        docBuilder.append("Contenido", noticias.getContenido());
        return docBuilder;
    }
    @Override
    public Document createDBObjectUsers(Usuarios usuarios) {
        Document docBuilder = new Document();

        docBuilder.append("UsuarioId", usuarios.getUsuarioId());
        docBuilder.append("Nombre", usuarios.getNombre());
        docBuilder.append("Role", usuarios.getRole());

        return docBuilder;
    }

    @Override
    public Noticias updateNoticias() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Noticias removeNoticias() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Noticias readNoticias() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
