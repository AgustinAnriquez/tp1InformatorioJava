package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.entities.Entrenador;
import com.tp1JavaJedi.services.EntrenadorService;

import java.util.Scanner;

public class EntrenadorServiceImpl implements EntrenadorService {
    @Override
    public Entrenador cargaEntrenador(Scanner scanner) {
        Entrenador entrenador = new Entrenador();
        System.out.println("ingrese nombre del entrenador");
        entrenador.setNombre(scanner.nextLine());
        System.out.println("Ingrese apellido del entrenador");
        entrenador.setApellido(scanner.nextLine());
        System.out.println("Ingrese edad del entrenador");
        entrenador.setEdad(scanner.nextInt());
        return entrenador;
    }
}
