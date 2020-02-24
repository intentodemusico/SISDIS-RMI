package classes;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
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
    MongoClientURI uri = new MongoClientURI("mongodb+srv://Admin:Informatica@rmi-p8iu2.mongodb.net/test?retryWrites=true&w=majority");
    MongoClient mongoClient = new MongoClient(uri);

    //Selección de DB
    MongoDatabase database = mongoClient.getDatabase("RMI");
    MongoCollection col = database.getCollection("Noticias");
    MongoCollection col2 = database.getCollection("Usuarios");

    private static final long serialVersionUID = 1L;

    /* (non-Javadoc)
     * @see classes.iRMI#sumar(int, int)
     */


    @Override
    public Noticias createNoticias(String nombre, String titular, String contenido) throws RemoteException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Noticias u = new Noticias();
        //u.setId(1);
        
        u.setNombre(nombre);
        u.setTitular(titular);
        u.setContenido(contenido);
        return u;

    }

    @Override
    public void createDBObjectNotices(Noticias noticias) throws RemoteException {
        Document docBuilder = new Document();

        docBuilder.append("_id", noticias.getId());
        docBuilder.append("Nombre", noticias.getNombre());
        docBuilder.append("Titular", noticias.getTitular());
        docBuilder.append("Fecha", noticias.getFechaCreado());
        docBuilder.append("Fecha", noticias.getFechaEditado());
        docBuilder.append("AutorId", noticias.getAutor());
        docBuilder.append("Contenido", noticias.getContenido());
        col.insertOne(docBuilder);
        System.out.println("Inserto Noticia");
    }




    @Override
    public void updateNoticias(int id, String contenido) throws RemoteException {
        Document document = new Document();
        document.put("_id", id);
        Document documentContenido = new Document();
        documentContenido.put("Contenido", contenido);
        col.updateOne(document, documentContenido);
    }

    @Override
    public void removeNoticias(int id) throws RemoteException {
        Document document = new Document();
        document.put("_id", id);
        col.deleteOne(document);
    }

    @Override
    public String readNoticias() throws RemoteException {
        System.out.println("Leyendo Noticias");
        String temp="";
        FindIterable<Document> cursor = col.find();

        for (Document doc : cursor) {
            temp+="\n"+doc.getString("Titular")+" Id:"+doc.getString("_id")+"\n"+doc.getString("Contenido");
            System.out.println(doc.getString("Contenido"));
        }
        return temp;

    }

}
