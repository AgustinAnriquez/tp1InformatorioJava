package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.utils.InitScanner;
import com.tp1JavaJedi.utils.Utils;
import com.tp1JavaJedi.entities.Equipo;
import com.tp1JavaJedi.services.EntrenadorService;
import com.tp1JavaJedi.services.EquipoService;
import com.tp1JavaJedi.services.JugadorService;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EquipoServiceImpl implements EquipoService {

    Scanner scanner = InitScanner.getScanner();
    EntrenadorService entrenadorService = new EntrenadorServiceImpl();
    JugadorService jugadorService = new JugadorServiceImpl();
    List<String> opcionesCargaJugadores = List.of("Carga manual de jugadores", "Carga por arhivo");

    @Override
    public Equipo cargaEquipo() {
        try{
            Equipo equipo = new Equipo();
            System.out.println("Ingrese nombre del equipo");
            equipo.setNombre(scanner.next());
            System.out.println("Ingrese fecha en que se creo el equipo");
            equipo.setFechaCreacion(Utils.parsearFecha(scanner.next()));
            System.out.println("Ingrese datos del entrenador del equipo");
            equipo.setEntrenador(entrenadorService.cargaEntrenador());
            int opcion = Utils.getOpcionConValidacion(opcionesCargaJugadores);
            equipo.setJugadores(jugadorService.cargaJugadores(equipo, opcion));
            return equipo;
        }catch (DateTimeParseException e){
            System.out.println("Datos ingresados son incorrecto, recuerde:");
            System.out.println("Formato de fecha: '22-10-2022'");
            return cargaEquipo();
        }
    }
}
