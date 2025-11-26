package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola(){

    }
    public static void mostrarMenuPrincipal(){
        System.out.println("Menú principal:");
        System.out.println("1. Controlar robot por defecto");
        System.out.println("2. Controlar robot indicando zona");
        System.out.println("3. Controlar robot indicando zona y orientación");
        System.out.println("4. Controlar robot indicando zona, orientación y coordenada inicial");
        System.out.println("5. Ejecutar comando");
        System.out.println("6. Salir");
    }
    public static int elegirOpcion(){
        int opcion;
        do {
            System.out.print("Introduce una opción: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 6);
        return opcion;
    }
    public static Zona elegirZona(){
        int ancho;
        int alto;
        Zona zona = null;
        do {
            System.out.println("Asigna el ancho de tu zona: ");
            ancho = Entrada.entero();
            System.out.println("Asigna el alto de tu zona: ");
            alto = Entrada.entero();
            try {
                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException iae) {
                System.out.println("Zona no valida. Intentalo de nuevo");
            }
        } while (zona == null);
        return zona;
    }
    public static void mostrarMenuOrientacion(){
        System.out.println("Menú de orientación:");
        System.out.println("1. Norte");
        System.out.println("2. Noreste");
        System.out.println("3. Este");
        System.out.println("4. Sureste");
        System.out.println("5. Sur");
        System.out.println("6. Suroeste");
        System.out.println("7. Oeste");
        System.out.println("8. Noroeste");
    }
    public static Orientacion elegirOrientacion(){
        Orientacion orientacion = null;
        int opcion;
        do {
            System.out.print("Introduce una opción: ");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion > 8);
        switch (opcion){
            case 1 -> orientacion = Orientacion.NORTE;
            case 2 -> orientacion = Orientacion.NORESTE;
            case 3 -> orientacion = Orientacion.ESTE;
            case 4 -> orientacion = Orientacion.SURESTE;
            case 5 -> orientacion = Orientacion.SUR;
            case 6 -> orientacion = Orientacion.SUROESTE;
            case 7 -> orientacion = Orientacion.OESTE;
            case 8 -> orientacion = Orientacion.NOROESTE;
        }
        return orientacion;
    }
    public static Coordenada elegirCoordenada(){
        int x;
        int y;

        System.out.println("Asigna el valor x: ");
        x = Entrada.entero();
        System.out.println("Asigna el valor y: ");
        y = Entrada.entero();

        return new Coordenada(x, y);
    }
    public static char elegirComando(){
        char comando;

        System.out.println("Que comando quieres usar?");
        comando = Entrada.caracter();

        return comando;
    }
    public  static void mostrarRobot(ControladorRobot controladorRobot){
        if (controladorRobot.getRobot() == null){
            System.out.println("El robot es nulo.");
        } else {
            System.out.println(controladorRobot.getRobot());
        }
    }
    public static void despedirse(){
        System.out.println("Adios, gracias por jugar.");
    }
}
