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
public class Jugador {
    private String nombre;
    private Mano mano;
    private int puntaje;
    private ManejadorColores manejador;
    private String avatar;
    private boolean tiradaInicial;

    public Jugador() {
        this.puntaje = 0;
        this.tiradaInicial = false;
    }

    public Jugador(Mano mano, int puntaje, ManejadorColores manejador, String avatar, boolean tiradaInicial) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.manejador = manejador;
        this.avatar = avatar;
        this.tiradaInicial = tiradaInicial;
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public ManejadorColores getManejador() {
        return manejador;
    }

    public void setManejador(ManejadorColores manejador) {
        this.manejador = manejador;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    void eliminarCoincidenciasSeleccionMano(List<Ficha> seleccion) {
        this.mano.eliminarCoincidenciasSeleccionMano(seleccion);
    }

    void incrementarPuntuacion(int numero) {
        this.puntaje += numero;
    }

    public boolean isTiradaInicial() {
        return tiradaInicial;
    }

    public void setTiradaInicial(boolean tiradaInicial) {
        this.tiradaInicial = tiradaInicial;
    }

    void agregarFichaMano(Ficha ficha) {
        this.mano.agregarFicha(ficha);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
