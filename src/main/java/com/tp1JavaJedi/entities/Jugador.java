package com.tp1JavaJedi.entities;

import com.tp1JavaJedi.entities.enums.Posicion;

public class Jugador {
    private int id;
    private String nombre;
    private String apellido;
    private float altura;
    private int cantGoles;
    private int cantPartidos;
    private boolean esCapitan;
    private int nroCamiseta;
    private Equipo equipo;
    private Posicion posicion;

    public Jugador() {
    }

    public Jugador(int id, String nombre, String apellido, float altura, int cantGoles, int cantPartidos, boolean esCapitan, int nroCamiseta, Equipo equipo, Posicion posicion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.cantGoles = cantGoles;
        this.cantPartidos = cantPartidos;
        this.esCapitan = esCapitan;
        this.nroCamiseta = nroCamiseta;
        this.equipo = equipo;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getCantGoles() {
        return cantGoles;
    }

    public void setCantGoles(int cantGoles) {
        this.cantGoles = cantGoles;
    }

    public int getCantPartidos() {
        return cantPartidos;
    }

    public void setCantPartidos(int cantPartidos) {
        this.cantPartidos = cantPartidos;
    }

    public boolean isEsCapitan() {
        return esCapitan;
    }

    public void setEsCapitan(boolean esCapitan) {
        this.esCapitan = esCapitan;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}
