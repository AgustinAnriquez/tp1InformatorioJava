package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.entities.Jugador;
import com.tp1JavaJedi.entities.enums.Posicion;
import com.tp1JavaJedi.services.JugadorService;

import java.util.Scanner;

public class JugadorServiceImpl implements JugadorService {


    @Override
    public Jugador cargaJugador(Scanner scanner) {
        Jugador jugador = new Jugador();
        System.out.println("Ingrese nombre del jugador");
        jugador.setNombre(scanner.nextLine());
        System.out.println("Ingrese apellido del jugador");
        jugador.setApellido(scanner.nextLine());
        System.out.println("Ingrese altura del jugador");
        jugador.setAltura(scanner.nextFloat());
        System.out.println("Ingrese cantidad de goles");
        jugador.setCantGoles(scanner.nextInt());
        System.out.println("Ingrese cantidad de partidos");
        jugador.setCantPartidos(scanner.nextInt());
        System.out.println("Ingrese numero de camiseta");
        jugador.setNroCamiseta(scanner.nextInt());
        System.out.println("Ingrese posicion");
        jugador.setPosicion(Posicion.valueOf(scanner.nextLine().toUpperCase()));
        return jugador;
    }
}
