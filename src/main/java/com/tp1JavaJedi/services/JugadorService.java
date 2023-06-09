package com.tp1JavaJedi.services;

import com.tp1JavaJedi.entities.Equipo;
import com.tp1JavaJedi.entities.Jugador;

import java.util.List;

public interface JugadorService {

     Jugador cargaJugador(Equipo equipo, boolean capitanCargado);
     List<Jugador> cargaJugadores(Equipo equipo, int opcion);

}
