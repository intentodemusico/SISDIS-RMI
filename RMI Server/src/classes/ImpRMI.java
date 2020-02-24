package classes;

import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

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
    public Noticias createNoticias(String nombre, String titular, String contenido, String autor) throws RemoteException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Noticias u = new Noticias();
        u.setId((int)col.count()+1);
        u.setNombre(nombre);
        u.setAutor(autor);
        u.setTitular(titular);
        u.setContenido(contenido);
        return u;

    }

    @Override
    public void createDBObjectNotices(Noticias noticias) throws RemoteException {
        Document docBuilder = new Document();
          System.out.println("Entrò");      
        docBuilder.append("id", noticias.getId());
        docBuilder.append("Nombre", noticias.getNombre());
        docBuilder.append("Titular", noticias.getTitular());
        docBuilder.append("FechaCreado", noticias.getFechaCreado());
        docBuilder.append("FechaEditado", noticias.getFechaEditado());
        docBuilder.append("Autor", noticias.getAutor());
        docBuilder.append("Contenido", noticias.getContenido());
        col.insertOne(docBuilder);
        System.out.println("Inserto Noticia");
    }




    @Override
    public void updateNoticias(int id, String contenido) throws RemoteException {

        Bson filter = eq("id", id);
        Bson updateOperation = set("Contenido", contenido);
        col.updateOne(filter, updateOperation);
    }

    @Override
    public void removeNoticias(int id) throws RemoteException {
        Document document = new Document();
        document.put("id", id);
        col.deleteOne(document);
    }

    @Override
    public String readNoticias() throws RemoteException {
        System.out.println("Leyendo Noticias");
        String temp="";
        FindIterable<Document> cursor = col.find();

        for (Document doc : cursor) {
            temp+="\n"+doc.getString("Titular")+"\n"+doc.getString("Contenido");
            System.out.println(doc.getString("Contenido"));
        }
        return temp;

    }

}
