package edu.utn.dds;

import edu.utn.dds.repository.PersonaDAO;
import edu.utn.dds.repository.PersonaDAOImpl;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        
        PersonaDAO repo = PersonaDAOImpl.getPersonaDAOInstance();

        repo.crearHuesped("43276352","John","Doe","DNI","Argentina");     

        menu();
        
    }
    public static void menu() {
        String op = null;
        do {
            System.out.println("MENU:");
            System.out.println("2 - Buscar Huésped");
            System.out.println("3 - Dar de alta Huésped");
            System.out.println("4 - Modificar Huésped");    // buscar Huesped (opcion 2) no devuelve un cliente y se necesita para modificar o eliminar
            System.out.println("5 - Dar de baja Huésped");
            System.out.println("6 - Salir");
            System.out.println("Ingrese una opción:");
            try {
            op = in.readLine(); 
            } catch (Exception e) {
                // TODO: handle exception
            }
            int opcion = Integer.parseInt(op);
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    menuBusqueda();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                default:
                    break;
            }

        } while (op.equals('6'));
    }
    public static void menuBusqueda() {
        String op1 = null;
        int opcionb = 0;
        do {
            
        System.out.println("Elija el campo a buscar");
        System.out.println("1 - Id");
        System.out.println("2 - DNI");
        System.out.println("3 - Nombre");
        System.out.println("4 - Apellido");
        System.out.println("5 - Cancelar");
        try {
            op1 = in.readLine();
        } catch (Exception e) {
            // TODO: handle exception
        }
        opcionb = Integer.parseInt(op1);
        } while (opcionb < 1 || opcionb > 5);
        switch (opcionb) {
            case 1:
                System.out.println("Ingrese el Id a buscar:");
                String id = null;
                try {
                id = in.readLine();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                int idInt = Integer.parseInt(id);
                // Buscar por ID
                break;
            case 2:
                System.out.println("Ingrese el DNI a buscar:");
                String dni = null;
                try {
                dni = in.readLine();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                int dniInt = Integer.parseInt(dni);
                // Buscar por DNI
                break;
            case 3:
                System.out.println("Ingrese el Nombre a buscar:");
                String nombre = null;
                try {
                nombre = in.readLine();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                // Buscar por Nombre
                break;
            case 4:
                System.out.println("Ingrese el Apellido a buscar:");
                String apellido = null;
                try {
                apellido = in.readLine();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                // Buscar por Apellido
                break;
        
            default:
                break;
        }
    }
}