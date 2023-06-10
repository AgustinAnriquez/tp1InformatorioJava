package com.tp1JavaJedi.services;

import com.tp1JavaJedi.entities.Equipo;

public interface EquipoService {

    Equipo cargaEquipo();
    void listarEquipoCapitan(Equipo equipo);
    void listarEquipoJugadores(Equipo equipo);
    void buscarEquipoYListar(String nombre, boolean listarJugadores);
    void eliminarEquipo(String nombre);

}
