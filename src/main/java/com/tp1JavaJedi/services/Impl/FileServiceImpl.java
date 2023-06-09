package com.tp1JavaJedi.services.Impl;

import com.tp1JavaJedi.entities.Equipo;
import com.tp1JavaJedi.entities.Jugador;
import com.tp1JavaJedi.entities.enums.Posicion;
import com.tp1JavaJedi.services.FileService;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<Jugador> cargaJugadoresPorArchivo(String path, Equipo equipo) {
        try {
            List<Jugador> jugadores = new ArrayList<>();
            List<String> lineas = FileUtils.readLines(new File(path), StandardCharsets.UTF_8);
            boolean capitanCargado = false;
            for (String linea : lineas) {
                String[] partes = linea.split(";");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String apellido = partes[2];
                float altura = Float.parseFloat(partes[3]);
                int cantGoles = Integer.parseInt(partes[4]);
                int cantPartidos = Integer.parseInt(partes[5]);
                boolean esCapitan = "Si".equals(partes[6]);
                if(capitanCargado && esCapitan){
                    throw new RuntimeException("no puede haber dos capitanes en el mismo equipo");
                }else if(esCapitan){
                    capitanCargado = true;
                }
                int nroCamiseta = Integer.parseInt(partes[7]);
                Posicion posicion = Posicion.valueOf(partes[8]);
                Jugador jugador = new Jugador(id, nombre, apellido, altura, cantGoles, cantPartidos, esCapitan, nroCamiseta, equipo, posicion);
                jugadores.add(jugador);
            }
            return jugadores;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
