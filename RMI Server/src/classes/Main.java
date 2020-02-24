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
            //Servicio RMI
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

 

    

}
