package com.tp1JavaJedi.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Utils {

    static Scanner scanner = InitScanner.getScanner();

    public static int getOpcion(List<String> opciones) {
        try {
            System.out.println("Seleccione una de las opciones");
            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + " " + opciones.get(i));
            }
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Solo puede ingresar valores numericos");
            scanner.next();
            return getOpcion(opciones);
        }

    }
    public static int getOpcionConValidacion(List<String> opciones) {
        int opcion = getOpcion(opciones);
        while (opcion < 1 || opcion > opciones.size() ){
            System.out.println("Ingrese una de las opciones (1 o 2)");
            opcion = getOpcion(opciones);
        }
        return opcion;
    }

    public static LocalDate parsearFecha(String fecha){
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(fecha, formato);
    }


}
