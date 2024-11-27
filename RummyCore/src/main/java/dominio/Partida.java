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
public class Partida {
    
    List<Jugador> jugadores;
    String estado;
    PozoFichas pozo;
    Tablero tablero;

    public Partida(List<Jugador> jugadores, String estado, PozoFichas pozo, Tablero tablero) {
        this.jugadores = jugadores;
        this.estado = estado;
        this.pozo = pozo;
        this.tablero = tablero;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PozoFichas getPozo() {
        return pozo;
    }

    public void setPozo(PozoFichas pozo) {
        this.pozo = pozo;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
    
}
