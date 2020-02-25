package classes;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        try {
            iRMI service = (iRMI) Naming.lookup("rmi://10.152.164.38:1802/service");
            System.out.println("conecto");
String nombreUsuario="Admin";
            String opcion = "-1";
            do {
                System.out.println("Escoja su opción");
                System.out.println("1. Leer\n2. Actualizar\n3. Eliminar\n0. Salir");
                opcion = myObj.nextLine();
                int id;
                String titular, contenido;
                switch (opcion) {  
                    case "1":
                        System.out.println(service.readNoticias());
                        break;

                    case "2":
                        System.out.println("Ingrese id");
                        id = Integer.parseInt(myObj.nextLine().trim());
                        System.out.println("Ingrese contenido");
                        contenido = myObj.nextLine();
                        service.updateNoticias(nombreUsuario,id, contenido);
                        break;

                    case "3":
                        System.out.println("Ingrese id");
                        id = Integer.parseInt(myObj.nextLine().trim());
                        service.removeNoticias(nombreUsuario,id);
                        break;

                    case "0":
                        System.out.println("Hasta luego");
                        break;

                    default:

                        System.out.println("Opción inválida");
                        break;
                }
            } while (!opcion.equals("0"));
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
