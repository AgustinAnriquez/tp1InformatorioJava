package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.entities.Jugador;
import com.tp1JavaJedi.init.InitData;
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
            equipo.setJugadores((opcion == 1)? jugadorService.cargaManual(equipo) : jugadorService.cargaPorArhivo(equipo));
            return equipo;
        }catch (DateTimeParseException e){
            System.out.println("Datos ingresados son incorrecto, recuerde:");
            System.out.println("Formato de fecha: '22(Dia)-10(Mes)-2022(Año)'");
            return cargaEquipo();
        }
    }

    @Override
    public void listarEquipoCapitan(Equipo equipo) {
        System.out.println("Datos del equipo");
        System.out.println("Nombre: "+ equipo.getNombre());
        System.out.println("Entrenador: "+ equipo.getEntrenador().getNombre());
        System.out.println("Capitan del equipo: "+ ((jugadorService.buscarCapitan(equipo)!= null)? jugadorService.buscarCapitan(equipo).getNombre(): "Error no encontramos el capitan"));
    }
    @Override
    public void listarEquipoJugadores(Equipo equipo) {
        System.out.println("Datos del equipo");
        System.out.println("Nombre: "+ equipo.getNombre());
        System.out.println("Entrenador: "+ equipo.getEntrenador().getNombre());
        System.out.println("Lista de jugadores");
        for(Jugador jugador: equipo.getJugadores()){
            jugadorService.listarJugador(jugador);
        }
    }

    @Override
    public void buscarEquipoYListar(String nombre, boolean listarJugadores) {
        Equipo equipoEncontrado = buscarEquipo(nombre);
            if (equipoEncontrado != null) {
                if (listarJugadores) {
                    listarEquipoJugadores(equipoEncontrado);
                } else {
                    listarEquipoCapitan(equipoEncontrado);
                }
            } else {
                System.out.println("Equipo no encontrado");
            }
        }

    @Override
    public void eliminarEquipo(String nombre) {
        List<Equipo> equipos = InitData.listaEquipos;
        Equipo equipoAEliminar = buscarEquipo(nombre);
        if (equipoAEliminar != null){
            equipos.remove(equipoAEliminar);
            System.out.println("Equipo eliminado exitosamente");
        }else {
            System.out.println("No se encontro el equipo que desea eliminar");
        }
    }

    private Equipo buscarEquipo(String nombre){
        List<Equipo> equipos = InitData.listaEquipos;
        if (equipos.isEmpty()){
            System.out.println("No hay equipos cargados");
            return null;
        }else{
            return equipos.stream()
                    .filter(equipo -> equipo.getNombre().equals(nombre))
                    .findFirst()
                    .orElse(null);
        }
    }

}
