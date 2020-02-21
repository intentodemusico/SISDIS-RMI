package classes;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.mongodb.MongoClientURI;
import java.net.UnknownHostException;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws UnknownHostException {

        try {
            //Conexión base de datos 
            MongoClientURI uri = new MongoClientURI(
                    "mongodb://Admin:<Informatica>@rmi-p8iu2.mongodb.net/test?retryWrites=true&w=majority");
            MongoClient mongoClient = new MongoClient(uri);
            DB db = mongoClient.getDB("RMI");
            

            
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
