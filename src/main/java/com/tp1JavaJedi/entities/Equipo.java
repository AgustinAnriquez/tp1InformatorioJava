package com.tp1JavaJedi.entities;

import java.time.LocalDate;
import java.util.List;

public class Equipo {

    private String nombre;
    private LocalDate fechaCreacion;
    private Entrenador entrenador;
    private List<Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(String nombre, LocalDate fechaCreacion){
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
