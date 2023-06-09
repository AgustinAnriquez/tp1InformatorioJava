package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.init.InitData;
import com.tp1JavaJedi.utils.Utils;
import com.tp1JavaJedi.services.EquipoService;
import com.tp1JavaJedi.services.Menu;

import java.util.List;

public class MenuImpl implements Menu {

    List<String> opcionesIniciales = List.of("Crear equipo", "Buscar jugador", "Buscar equipo (capitan)","Buscar equipo(jugadores)", "Eliminar equipo", "Salir");
    List<String> opcionesCrearEquipo = List.of("Cargar equipo", "Volver");
    EquipoService equipoService = new EquipoServiceImpl();

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
            case 2 -> System.out.println("Buscar jugador");
            case 3 -> System.out.println("Buscar jugador(muestra capitan)");
            case 4 -> System.out.println("Buscar jugadores (muestra jugadores)");
            case 5 -> System.out.println("Eliminar equipo");
            case 6 -> salir = true;
            default -> System.out.println("Solo puede ingresar valores del 1 al 6");
        }
        return salir;
    }

    private boolean menuCargarEquipo(int opcionCrearEquipo) {

        switch (opcionCrearEquipo) {
            case 1 -> InitData.listaEquipos.add(equipoService.cargaEquipo());
            case 2 -> {
                return true;
            }
            default -> System.out.println("Solo puede ingresar valores del 1 al 2");
        }
        return false;
    }

}
