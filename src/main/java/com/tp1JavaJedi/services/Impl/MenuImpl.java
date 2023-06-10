package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.entities.Equipo;
import com.tp1JavaJedi.init.InitData;
import com.tp1JavaJedi.utils.InitScanner;
import com.tp1JavaJedi.utils.Utils;
import com.tp1JavaJedi.services.EquipoService;
import com.tp1JavaJedi.services.JugadorService;
import com.tp1JavaJedi.services.FileService;
import com.tp1JavaJedi.services.Menu;

import java.util.List;
import java.util.Scanner;

public class MenuImpl implements Menu {

    List<String> opcionesIniciales = List.of("Crear equipo", "Buscar jugador", "Buscar equipo (se muestra capitan)","Buscar equipo(se muestra jugadores)", "Eliminar equipo", "Salir");
    List<String> opcionesCrearEquipo = List.of("Cargar equipo", "Volver");
    List<String> opcionesExportarJugadores = List.of("Exportar jugadores", "No exportar");
    EquipoService equipoService = new EquipoServiceImpl();
    FileService fileService = new FileServiceImpl();

    JugadorService jugadorService = new JugadorServiceImpl();

    Scanner scanner = InitScanner.getScanner();

    int opcionInicial;
    boolean salir = false;

    @Override
    public void initMenu() {

        while (!salir){
            opcionInicial = Utils.getOpcion(opcionesIniciales);
                salir = menuPrincipal(opcionInicial, salir);
        }
    }

    private boolean menuPrincipal(int opcionInicial, boolean salir) {
        switch (opcionInicial) {
            case 1 -> {
                boolean volver = false;
                while (!volver) {
                    int opcionCrearEquipo = Utils.getOpcion(opcionesCrearEquipo);
                    volver = this.menuCargarEquipo(opcionCrearEquipo);
                }
            }
            case 2 -> {
                System.out.println("Ingrese nombre de jugador que desea buscar");
                jugadorService.buscarJugador(scanner.next());
            }
            case 3 ->{
                System.out.println("Ingrese nombre del equipo que desea buscar");
                equipoService.buscarEquipoYListar(scanner.next(), false);
            }
            case 4 ->{
                System.out.println("Ingrese nombre del equipo que desea buscar");
                equipoService.buscarEquipoYListar(scanner.next(), true);
            }
            case 5 ->{
                System.out.println("Ingrese nombre del equipo que desea eliminar");
                equipoService.eliminarEquipo(scanner.next());
            }
            case 6 -> salir = true;
            default -> System.out.println("Solo puede ingresar valores del 1 al 6");
        }
        return salir;
    }

    private boolean menuCargarEquipo(int opcionCrearEquipo) {

        switch (opcionCrearEquipo) {
            case 1 ->{
                Equipo equipo = equipoService.cargaEquipo();
                int opcionExportarJugadores = Utils.getOpcionConValidacion(opcionesExportarJugadores);
                if (opcionExportarJugadores == 1)fileService.exportarJugadores(equipo.getJugadores(), "src/main/java/com/tp1JavaJedi/resources/jugadores-salida.txt");
                InitData.listaEquipos.add(equipo);
            }
            case 2 -> {
                return true;
            }
            default -> System.out.println("Solo puede ingresar valores del 1 al 2");
        }
        return false;
    }

}
