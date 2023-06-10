package com.tp1JavaJedi.services;

import com.tp1JavaJedi.entities.Equipo;
import com.tp1JavaJedi.entities.Jugador;

import java.util.List;

public interface JugadorService {

     Jugador cargaJugador(Equipo equipo, boolean capitanCargado);
     List<Jugador> cargaManual(Equipo equipo);
     List<Jugador> cargaPorArhivo(Equipo equipo);

     void listarJugador(Jugador jugador);

     void buscarJugador(String nombre);

     Jugador buscarCapitan(Equipo equipo);


}
