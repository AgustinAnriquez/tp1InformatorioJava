package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.services.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class MenuImpl implements Menu {

    @Override
    public void initMenu() {
        Scanner scanner = new Scanner(System.in);
        List<String> opcionesIniciales = List.of("Crear equipo", "Buscar jugador", "Buscar equipo (capitan)","Buscar equipo(jugadores)", "Eliminar equipo", "Salir");
        int opcion;
        boolean salir = false;

        while (!salir){
            opcion = getOpcion(scanner, opcionesIniciales);
            try{
                switch (opcion) {
                    case 1:
                        System.out.println("Crear equipo");
                        break;
                    case 2:
                        System.out.println("Buscar jugador");
                        break;
                    case 3:
                        System.out.println("Buscar jugador(muestra capitan)");
                        break;
                    case 4:
                        System.out.println("Buscar jugador(muestra jugadores");
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
            }catch (InputMismatchException e) {
                System.out.println("Debes ingresar un número");
                scanner.next();
            }
        }
    }

    private static int getOpcion(Scanner scanner, List<String> opciones) {
        System.out.println("Seleccione una de las opciones");
        for (int i=0;i<opciones.size();i++) {
            System.out.println((i+1)+ opciones.get(i));
        }
        return scanner.nextInt();
    }
}
