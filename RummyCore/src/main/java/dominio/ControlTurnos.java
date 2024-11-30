/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.List;

/**
 *
 * @author eduar
 */
public class ControlTurnos {
    
    private List<Jugador> jugadores;
    private int jugadorActual;
    private boolean grupoCortado;

    public ControlTurnos() {
    }

    public ControlTurnos(List<Jugador> jugadores, int jugadorActual) {
        this.jugadores = jugadores;
        this.jugadorActual = jugadorActual;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(int jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public boolean isGrupoCortado() {
        return grupoCortado;
    }

    public void setGrupoCortado(boolean grupoCortado) {
        this.grupoCortado = grupoCortado;
    }

    void incrementarPuntuacion(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Jugador obtenerJugadorActual() {
        return this.jugadores.get(jugadorActual);
    }

    void eliminarCoincidenciasSeleccionMano() {
        this.obtenerJugadorActual().eliminarCoincidenciasSeleccionMano();
    }
    
}
