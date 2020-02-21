package classes;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
    public Usuarios createUsuarios() throws RemoteException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Usuarios u = new Usuarios();
        u.setUsuarioId(1);
        u.setNombre("Oswaldo");
        u.setRole(1);
        return u;

    }

    @Override
    public Noticias createNoticias() throws RemoteException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Noticias u = new Noticias();
        u.setId(1);
        u.setNombre("Bomba");
        u.setTitular("Bomba en la UPB");
        try {
            u.setFecha(format.parse("2009-12-31"));
        } catch (ParseException ex) {
            Logger.getLogger(ImpRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.setAutorId(1);
        u.setContenido("Hubo una bomba, muriendo x personas");

        return u;

    }
    @override
    public Document createDBObjectNotices(Noticias noticias) {
        Document docBuilder = new Document();

        docBuilder.append("_id", noticias.getId());
        docBuilder.append("Nombre", noticias.getNombre());
        docBuilder.append("Titular", noticias.getTitular());
        docBuilder.append("Fecha", noticias.getFecha());
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

}
