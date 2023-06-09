package com.tp1JavaJedi.services;

import com.tp1JavaJedi.entities.Equipo;
import com.tp1JavaJedi.entities.Jugador;

import java.io.IOException;
import java.util.List;

public interface FileService {

    List<Jugador> cargaJugadoresPorArchivo(String path, Equipo equipo);

}
