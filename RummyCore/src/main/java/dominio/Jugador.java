/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author eduar
 */
public class Jugador {
    Mano mano;
    int puntaje;
    ManejadorColores manejador;

    public Jugador() {
    }

    public Jugador(Mano mano, int puntaje, ManejadorColores manejador) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.manejador = manejador;
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
}
