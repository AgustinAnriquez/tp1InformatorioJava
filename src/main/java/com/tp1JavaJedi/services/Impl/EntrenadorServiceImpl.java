package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.utils.InitScanner;
import com.tp1JavaJedi.entities.Entrenador;
import com.tp1JavaJedi.services.EntrenadorService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntrenadorServiceImpl implements EntrenadorService {

    Scanner scanner = InitScanner.getScanner();

    @Override
    public Entrenador cargaEntrenador() {
        try{
            Entrenador entrenador = new Entrenador();
            System.out.println("ingrese nombre del entrenador");
            entrenador.setNombre(scanner.next());
            System.out.println("Ingrese apellido del entrenador");
            entrenador.setApellido(scanner.next());
            System.out.println("Ingrese edad del entrenador");
            entrenador.setEdad(scanner.nextInt());
            return entrenador;
        }catch (InputMismatchException e) {
            System.out.println("Datos ingresados son incorrecto, recuerde:");
            System.out.println("ingresar un numero para la edad");
            scanner.next();
            return cargaEntrenador();
        }

    }
}
