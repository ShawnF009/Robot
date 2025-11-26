package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;



public class Main {

    private static ControladorRobot controladorRobot;

    public static void main(String[] args) {
        int opcion;
        do {
            Consola.mostrarMenuPrincipal();
            opcion = Consola.elegirOpcion();
            ejecutarOpcion(opcion);
        } while (opcion != 6);
        Consola.despedirse();
    }
    public static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> controlarRobotDefecto();
            case 2 -> controlarRobotZona();
            case 3 -> controlarRobotZonaOrientacion();
            case 4 -> controlarRobotZonaOrientacionCoordenada();
            case 5 -> ejecutarComando();
            case 6 -> Consola.despedirse();
        }
        Consola.mostrarRobot(controladorRobot);
    }

    public static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());
    }

    public static void controlarRobotZona() {
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));
    }

    public static void controlarRobotZonaOrientacion() {
        Consola.mostrarMenuOrientacion();
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));
    }

    public static void controlarRobotZonaOrientacionCoordenada() {
        Consola.mostrarMenuOrientacion();
        controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(),Consola.elegirCoordenada()));
    }

    public static void ejecutarComando() {
        try {
            controladorRobot.ejecutar(Consola.elegirComando());
        } catch (RobotExcepcion e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

