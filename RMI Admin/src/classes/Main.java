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
            iRMI service = (iRMI) Naming.lookup("rmi://127.0.0.1:1802/service");
            System.out.println("conecto");
            System.out.println("elija tipo de usuario (0/1) ");
            String tipoUsuario = myObj.nextLine();

            System.out.println("elija nombre de usuario (0/1) ");
            String nombreUsuario = myObj.nextLine();
            String opcion = "-1";
            do {
                System.out.println("Escoja su opción");
                System.out.println("1. Crear \n2. Leer\n3. Actualizar\n4. Eliminar\n0. Salir");
                opcion = myObj.nextLine();
                switch (opcion) {
                    case "1":
                        service.readNoticias();
                        break;

                    case "2":
                        service.updateNoticias();
                        break;

                    case "3":
                        service.removeNoticias();
                        break;

                    case "0":
                        System.out.println("Hasta luego");
                        break;

                    default:

                        System.out.println("Opción inválida");
                        break;
                }
            } while (opcion != "0");
        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
