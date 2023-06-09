package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.services.FileService;
import com.tp1JavaJedi.utils.InitScanner;
import com.tp1JavaJedi.utils.Utils;
import com.tp1JavaJedi.entities.Equipo;
import com.tp1JavaJedi.entities.Jugador;
import com.tp1JavaJedi.entities.enums.Posicion;
import com.tp1JavaJedi.services.JugadorService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JugadorServiceImpl implements JugadorService {

    Scanner scanner = InitScanner.getScanner();

    List<String> opcionesEsCapitan = List.of("Es capitan", "No es capitan");

    FileService fileService = new FileServiceImpl();

    @Override
    public Jugador cargaJugador(Equipo equipo, boolean capitanCargado) {
        try {
            Jugador jugador = new Jugador();
            System.out.println("Ingrese nombre del jugador");
            jugador.setNombre(scanner.next());
            System.out.println("Ingrese apellido del jugador");
            jugador.setApellido(scanner.next());
            System.out.println("Ingrese altura del jugador (ejemplo: '1,60')");
            jugador.setAltura(scanner.nextFloat());
            System.out.println("Ingrese cantidad de goles");
            jugador.setCantGoles(scanner.nextInt());
            System.out.println("Ingrese cantidad de partidos");
            jugador.setCantPartidos(scanner.nextInt());
            System.out.println("Ingrese numero de camiseta");
            jugador.setNroCamiseta(scanner.nextInt());
            System.out.println("Ingrese posicion");
            jugador.setPosicion(Posicion.valueOf(scanner.next().toUpperCase()));
            if(capitanCargado){
                jugador.setEsCapitan(false);
            }else{
                int opcion = Utils.getOpcionConValidacion(opcionesEsCapitan);
                jugador.setEsCapitan(opcion == 1);
            }
            jugador.setEquipo(equipo);
            return jugador;
        }catch (InputMismatchException e) {
            System.out.println("Datos ingresados son incorrecto, recuerde:");
            System.out.println("ingresar la altura de esta forma: '1,60'");
            System.out.println("ingresar datos numericos para cantidad de partidos, cantidad de goles y numero de camiseta");
            scanner.next();
            return cargaJugador(equipo, capitanCargado);
        }catch (IllegalArgumentException e) {
            System.out.println("Datos ingresados son incorrecto, recuerde:");
            System.out.println("posiciones permitidas: ARQUERO, DEFENSOR, MEDIOCAMPISTA, DELANTERO");
            scanner.next();
            return cargaJugador(equipo, capitanCargado);
        }

    }

    public List<Jugador> cargaJugadores(Equipo equipo, int opcion){
        if (opcion == 1){
            return cargaManual(equipo);
        }else {
            return cargaPorArhivo(equipo);
        }
    }
    private List<Jugador> cargaPorArhivo(Equipo equipo){
        return fileService.cargaJugadoresPorArchivo("com/tp1JavaJedi/resources/jugadores-entrada.txt", equipo);
    }

    private List<Jugador> cargaManual(Equipo equipo) {
        System.out.println("Ingrese cantidad de jugadores que desea cargar para este equipo");
        int cantJugadores = scanner.nextInt();
        List<Jugador> jugadores = new ArrayList<>();
        boolean capitanCargado = false;
        for (int i=0;i<cantJugadores;i++) {
            Jugador jugador = cargaJugador(equipo, capitanCargado);
            if(jugador.isEsCapitan()){
                capitanCargado = true;
            }
            jugadores.add(jugador);
        }
        return jugadores;
    }



}
