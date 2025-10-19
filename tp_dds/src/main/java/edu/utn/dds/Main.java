package edu.utn.dds;

import edu.utn.dds.model.Contacto;
import edu.utn.dds.repository.PersonaDAO;
import edu.utn.dds.repository.PersonaDAOImpl;
import edu.utn.dds.service.HuespedService;
import edu.utn.dds.service.HuespedServiceImpl;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        HuespedService service = new HuespedServiceImpl();

        login();
        menu();
    }

    public static void login(){
        Scanner input = new Scanner(System.in);
        String user = "ADMIN";
        String password = "ACUAMAN8D";

        String input_user;
        String input_password;

        do {
            System.out.println("Usuario: ");
            input_user = input.nextLine();
            System.out.println("Contrasenya: ");
            input_password = input.nextLine();

            if(input_user != user || input_password != password){
                System.out.println("Credenciales no validas.");
            }
        } while (input_user != user || input_password != password);


        input.close();
    }

    public static void menu() {
        String op = null;
        do {
            System.out.println("MENU:");
            System.out.println("1 - Buscar Huésped");
            System.out.println("2 - Dar de alta Huésped");
            System.out.println("3 - Modificar Huésped");    // buscar Huesped (opcion 2) no devuelve un cliente y se necesita para modificar o eliminar
            System.out.println("4 - Dar de baja Huésped");
            System.out.println("5 - Salir");
            System.out.println("Ingrese una opción:");
            try {
                op = in.readLine(); 
            } catch (IOException e) {
                e.getStackTrace();
            }
            int opcion = Integer.parseInt(op);
            switch (opcion) {
                case 1:
                    menuBusqueda();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
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
        } catch (IOException e) {
            e.getStackTrace();
        }
        opcionb = Integer.parseInt(op1);
        } while (opcionb < 1 || opcionb > 5);
        switch (opcionb) {
            case 1:
                System.out.println("Ingrese el Id a buscar:");
                String id = null;
                try {
                id = in.readLine();
                } catch (IOException e) {
                    e.getStackTrace();
                }
                int idInt = Integer.parseInt(id);
                // Buscar por ID
                break;
            case 2:
                System.out.println("Ingrese el DNI a buscar:");
                String dni = null;
                try {
                dni = in.readLine();
                } catch (IOException e) {
                    e.getStackTrace();
                }
                int dniInt = Integer.parseInt(dni);
                // Buscar por DNI
                break;
            case 3:
                System.out.println("Ingrese el Nombre a buscar:");
                String nombre = null;
                try {
                nombre = in.readLine();
                } catch (IOException e) {
                    e.getStackTrace();
                }
                // Buscar por Nombre
                break;
            case 4:
                System.out.println("Ingrese el Apellido a buscar:");
                String apellido = null;
                try {
                apellido = in.readLine();
                } catch (IOException e) {
                    e.getStackTrace();
                }
                // Buscar por Apellido
                break;
        
            default:
                break;
        }
    }
}