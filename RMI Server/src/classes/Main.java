package classes;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static java.lang.String.format;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import org.bson.Document;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws UnknownHostException, ParseException {

        try {
            //Conexión base de datos 

            MongoClientURI uri = new MongoClientURI("mongodb+srv://Admin:Informatica@rmi-p8iu2.mongodb.net/test?retryWrites=true&w=majority");
            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("RMI");
            MongoCollection col = database.getCollection("Noticias");
            Noticias noticias = createNoticias();
            col.insertOne(createDBObject(noticias));
            System.out.println("Inserto");

            iRMI service = new ImpRMI();
            LocateRegistry.createRegistry(1802);
            Naming.rebind("//127.0.0.1:1802/service", service);
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static Noticias createNoticias() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Noticias u = new Noticias();
        u.setId(1);
        u.setNombre("Bomba");
        u.setTitular("Bomba en la UPB");
        u.setFecha(format.parse("2009-12-31"));
        u.setAutorId(1);
        u.setContenido("Hubo una bomba, muriendo x personas");

        return u;

    }

    private static Document createDBObject(Noticias noticias) {
        Document docBuilder = new Document();

        docBuilder.append("_id", noticias.getId());
        docBuilder.append("Nombre", noticias.getNombre());
        docBuilder.append("Titular", noticias.getTitular());
        docBuilder.append("Fecha", noticias.getFecha());
        docBuilder.append("AutorId", noticias.getAutorId());
        docBuilder.append("Contenido", noticias.getContenido());
        return docBuilder;
    }

}
