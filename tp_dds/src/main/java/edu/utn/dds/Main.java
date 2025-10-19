package edu.utn.dds;

import edu.utn.dds.model.Contacto;
import edu.utn.dds.repository.PersonaDAO;
import edu.utn.dds.repository.PersonaDAOImpl;
import edu.utn.dds.service.HuespedService;
import edu.utn.dds.service.HuespedServiceImpl;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

import edu.utn.dds.dto.HuespedDTO;
import edu.utn.dds.exception.*;

public class Main {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static HuespedService service = new HuespedServiceImpl();

    public static void main(String[] args) throws HuespedNoCreadoException, HuespedNoEncontradoException, IdInvalidoException {
        //login();
        menu();
    }

    public static void login() {
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

            if (!input_user.equals(user) || !input_password.equals(password)) {
                System.out.println("Credenciales no validas.");
            }
        } while (!input_user.equals(user) || !input_password.equals(password));

        input.close();
    }

    public static void menu() {
        String op = null;
        do {
            System.out.println("MENU:");
            System.out.println("1 - Buscar Huésped");
            System.out.println("2 - Dar de alta Huésped");
            System.out.println("3 - Modificar Huésped");
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
                    crearHuesped();
                    break;
                case 3:
                    modificarHuesped();
                    break;
                case 4:
                    borrarHuesped();
                    break;
                default:
                    break;
            }
        } while (!op.equals(5));
    }

    public static void menuBusqueda() {
        String id = null;
        String tipoDni = null;
        String dni = null;
        String nombre = null;
        String apellido = null;
        List<HuespedDTO> huespedes = null;

        try{
            System.out.println("Ingrese ID del huesped: ");
            id = in.readLine();

            System.out.println("Ingrese el tipo de DNI:");
            tipoDni = in.readLine();

            System.out.println("Ingrese el DNI:");
            dni = in.readLine();

            System.out.println("Ingrese el Nombre:");
            nombre = in.readLine();

            System.out.println("Ingrese el Apellido:");
            apellido = in.readLine();

            if(id.isEmpty())
                id = null;
            if (dni.isEmpty())
                dni = null;
            if (nombre.isEmpty())
                nombre = null;
            if (apellido.isEmpty())
                apellido = null;
            if (tipoDni.isEmpty());
                tipoDni = null;

            huespedes = service.buscarHuesped(id, dni, nombre, apellido, apellido);
        }catch(IOException e){
            e.getStackTrace();
        }catch(HuespedNoEncontradoException e) {
            e.getMessage();
            crearHuesped();
        }
        catch(IdInvalidoException e) {
            e.getMessage();
        }

        if(huespedes != null) {
            for(HuespedDTO huesped : huespedes) {
                System.out.println(huesped.toString());
            }
        }
    }

    public static void crearHuesped() {
        String tipoDni = null;
        String dni = null;
        String nombre = null;
        String apellido = null;
        String doB = null;
        String nacionalidad = null;
        String telefono = null;
        String email = null;
        String direccion = null;

        try{
            System.out.println("Ingrese el tipo de DNI:");
            tipoDni = in.readLine();

            System.out.println("Ingrese el DNI:");
            dni = in.readLine();
            
            System.out.println("Ingrese el Nombre:");
            nombre = in.readLine();

            System.out.println("Ingrese el Apellido:");
            apellido = in.readLine();

            System.out.println("Ingrese la Fecha de Nacimiento (dd-MM-yyyy):");
            doB = in.readLine();

            System.out.println("Ingrese la Nacionalidad:");
            nacionalidad = in.readLine();

            System.out.println("Ingrese el Telefono:");
            telefono = in.readLine();

            System.out.println("Ingrese el Email:");
            email = in.readLine();

            System.out.println("Ingrese la Direccion:");
            direccion = in.readLine();

            service.crearHuesped(dni, nombre, apellido, tipoDni, nacionalidad, doB, telefono, email, direccion);
        }catch(IOException e) {
            e.getStackTrace();
        }
        catch(HuespedNoCreadoException e) {
            e.getMessage();
        }
    }

    public static void modificarHuesped() {
        String dni = null;
        String tipoDni = null;
        String nombre = null;
        String apellido = null;
        String doB = null;
        String nacionalidad = null;
        String telefono = null;
        String email = null;
        String direccion = null;
        String idHuespedAModificar = null;

        System.out.println("Ingrese los campos del Huesped a buscar para modificar.");
        try {
            System.out.print("DNI: ");
            dni = in.readLine();
            System.out.print("Nombre: ");
            nombre = in.readLine();
            System.out.print("Apellido: ");
            apellido = in.readLine();
            System.out.print("Tipo Documento: ");
            tipoDni = in.readLine();

            if (dni.isEmpty())
                dni = null;
            if (nombre.isEmpty())
                nombre = null;
            if (apellido.isEmpty())
                apellido = null;
            if (tipoDni.isEmpty())
                tipoDni = null;

            service.mostrarListadoHuespedes(dni, nombre, apellido, tipoDni);

            System.out.print("Ingrese el ID del Huesped a modificar: ");
            idHuespedAModificar = in.readLine();

            System.out.println("Dejar vacío y presionar Enter para mantener el valor actual.");
            System.out.println("Nuevo tipo de DNI:");

            System.out.println("DNI:");
            tipoDni = in.readLine();
            System.out.println("Nombre:");
            nombre = in.readLine();
            System.out.println("Apellido:");
            apellido = in.readLine();
            System.out.println("Fecha de Nacimiento (YYYY-MM-DD):");
            doB = in.readLine();
            System.out.println("Nacionalidad:");
            nacionalidad = in.readLine();
            System.out.println("Telefono:");
            telefono = in.readLine();
            System.out.println("Email:");
            email = in.readLine();
            System.out.println("Direccion:");
            direccion = in.readLine();

            if(idHuespedAModificar.isEmpty())
                idHuespedAModificar = null;
            if (dni.isEmpty())
                dni = null;
            if (nombre.isEmpty())
                nombre = null;
            if (apellido.isEmpty())
                apellido = null;
            if (tipoDni.isEmpty())
                tipoDni = null;
            if (doB.isEmpty())
                doB = null;
            if (nacionalidad.isEmpty())
                nacionalidad = null;
            if (telefono.isEmpty())
                telefono = null;
            if (email.isEmpty())
                email = null;
            if (direccion.isEmpty())
                direccion = null;

            service.modificarHuesped(idHuespedAModificar, tipoDni, nombre, apellido, dni, nacionalidad, doB, telefono, email, direccion);
        } catch (IOException e) {
            e.getStackTrace();
        } catch (IdInvalidoException e) {
            e.getMessage();
        } catch (HuespedNoEncontradoException e) {
            e.getMessage();
        }
    }

    public static void borrarHuesped() {
        String dni = null;
        String tipoDni = null;
        String nombre = null;
        String apellido = null;
        String idHuespedABorrar = null;
        
        System.out.println("Ingrese los campos del Huesped a buscar para borrar.");
        try {
            System.out.print("DNI: ");
            dni = in.readLine();
            System.out.print("Nombre: ");
            nombre = in.readLine();
            System.out.print("Apellido: ");
            apellido = in.readLine();
            System.out.print("Tipo Documento: ");
            tipoDni = in.readLine();

            if (dni.isEmpty())
                dni = null;
            if (nombre.isEmpty())
                nombre = null;
            if (apellido.isEmpty())
                apellido = null;
            if (tipoDni.isEmpty())
                tipoDni = null;
        
            service.mostrarListadoHuespedes(dni, nombre, apellido, tipoDni);

            System.out.print("Ingrese el ID del Huesped a modificar: ");
            idHuespedABorrar = in.readLine();
            
            service.borrarHuesped(idHuespedABorrar);

        } catch (IOException e) {
            e.getStackTrace();
        } catch (IdInvalidoException e) {
            e.getMessage();
        } catch (HuespedNoEncontradoException e) {
            e.getMessage();
        }
    }
}