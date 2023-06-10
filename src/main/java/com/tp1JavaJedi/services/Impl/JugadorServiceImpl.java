package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.init.InitData;
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
    public List<Jugador> cargaPorArhivo(Equipo equipo){
        return fileService.cargaJugadoresPorArchivo("com/tp1JavaJedi/resources/jugadores-entrada.txt", equipo);
    }

    @Override
    public void listarJugador(Jugador jugador) {
        System.out.println("Datos del jugador");
        System.out.println("Nombre: "+ jugador.getNombre());
        System.out.println("Apellido: "+ jugador.getApellido());
        System.out.println("Posicion: "+ jugador.getPosicion().name());
        System.out.println("Capitan: "+ (jugador.isEsCapitan()? "Si": "No"));
        System.out.println("Nombre del equipo: " + jugador.getEquipo().getNombre());
    }

    @Override
    public void buscarJugador(String nombre) {
        List<Jugador> jugadores = InitData.listaJugadores;
        if (jugadores.isEmpty()){
            System.out.println("No hay jugadores cargados");
        }else{
            Jugador jugadorEncontrado = jugadores.stream()
                    .filter(jugador -> jugador.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);

            if (jugadorEncontrado != null) {
                listarJugador(jugadorEncontrado);
            } else {
                System.out.println("Jugador no encontrado");
            }
        }
    }

    public List<Jugador> cargaManual(Equipo equipo) {
        System.out.println("Ingrese cantidad de jugadores que desea cargar para este equipo");
        int cantJugadores = scanner.nextInt();
        List<Jugador> jugadores = new ArrayList<>();
        boolean capitanCargado = false;
        for (int i=0;i<cantJugadores;i++) {
            Jugador jugador = cargaJugador(equipo, capitanCargado);
            if(jugador.isEsCapitan()){
                capitanCargado = true;
            }
            InitData.listaJugadores.add(jugador);
            jugadores.add(jugador);
        }
        return jugadores;
    }

    public Jugador buscarCapitan(Equipo equipo){
        List<Jugador> jugadores = equipo.getJugadores();
        return jugadores.stream()
                .filter(jugador -> jugador.isEsCapitan())
                .findFirst()
                .orElse(null);
    }



}
