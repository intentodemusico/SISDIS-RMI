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
            iRMI service = (iRMI) Naming.lookup("rmi://10.152.164.30:1802/service");
            System.out.println("conecto");

            System.out.println("elija nombre de usuario (0/1) ");
            String nombreUsuario = myObj.nextLine();
            String opcion = "-1";
            do {
                System.out.println("Escoja su opción");
                System.out.println("1. Crear \n2. Leer\n3. Actualizar\n4. Eliminar\n0. Salir");
                opcion = myObj.nextLine();
                int id;
                String titular, contenido, nombre;
                switch (opcion) {
                    case "1":
                        System.out.println("Ingrese titular");
                        titular = myObj.nextLine();
                        System.out.println("Ingrese contenido");
                        contenido = myObj.nextLine();
                        System.out.println("Ingrese nombre");
                        nombre = myObj.nextLine();
                        service.createDBObjectNotices(service.createNoticias(nombre, titular, contenido, nombreUsuario));
                        break;

                    case "2":
                        System.out.println(service.readNoticias());
                        break;

                    case "3":
                        System.out.println("Ingrese id");
                        id = Integer.parseInt(myObj.nextLine().trim());
                        System.out.println("Ingrese contenido");
                        contenido = myObj.nextLine();
                        service.updateNoticias(id, contenido);
                        break;

                    case "4":
                        System.out.println("Ingrese id");
                        id = Integer.parseInt(myObj.nextLine().trim());
                        service.removeNoticias(id);
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
