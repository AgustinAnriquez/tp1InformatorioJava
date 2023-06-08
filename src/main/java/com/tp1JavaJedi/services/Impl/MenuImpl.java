package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.services.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class MenuImpl implements Menu {

    Scanner scanner = new Scanner(System.in);
    List<String> opcionesIniciales = List.of("Crear equipo", "Buscar jugador", "Buscar equipo (capitan)","Buscar equipo(jugadores)", "Eliminar equipo", "Salir");
    List<String> opcionesCrearEquipo = List.of("Carga manual", "Importar equipo", "Volver");
    int opcion;
    boolean salir = false;

    @Override
    public void initMenu() {

        while (!salir){
            opcion = getOpcion(opcionesIniciales);
            try{
                salir = menuPrincipal(opcion, salir);
            }catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                scanner.next();
            }
        }
    }

    private boolean menuPrincipal(int opcion, boolean salir) {
        switch (opcion) {
            case 1:
                int opcionCrearEquipo = getOpcion(opcionesCrearEquipo);
                this.menuCargarEquipo(opcionCrearEquipo);
            case 2:
                System.out.println("Buscar jugador");
                break;
            case 3:
                System.out.println("Buscar jugador(muestra capitan)");
                break;
            case 4:
                System.out.println("Buscar jugadores (muestra jugadores)");
                break;
            case 5:
                System.out.println("Eliminar equipo");
                break;
            case 6:
                salir = true;
                break;
            default:
                System.out.println("Solo puede ingresar valores del 1 al 6");
        }
        return salir;
    }

    private void menuCargarEquipo(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Se pide datos del equipo");
            case 2:
                System.out.println("Se usa metodo para importar jugadores");
                break;
            case 3:
                this.initMenu();
                break;
            default:
                System.out.println("Solo puede ingresar valores del 1 al 3");
        }
    }

    private int getOpcion(List<String> opciones) {
        System.out.println("Seleccione una de las opciones");
        for (int i=0;i<opciones.size();i++) {
            System.out.println((i+1)+ opciones.get(i));
        }
        return scanner.nextInt();
    }

    private void cargaManualDeJugadores(){
        System.out.println("ingrese cantidad de jugadores");
        int cantJugadores = scanner.nextInt();
        for (int i=0;i<cantJugadores;i++) {

        }
    }
}
