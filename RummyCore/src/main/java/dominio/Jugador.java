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
    private Mano mano;
    private int puntaje;
    private ManejadorColores manejador;
    private String avatar;

    public Jugador() {
    }

    public Jugador(Mano mano, int puntaje, ManejadorColores manejador, String avatar) {
        this.mano = mano;
        this.puntaje = puntaje;
        this.manejador = manejador;
        this.avatar = avatar;
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

    void eliminarCoincidenciasSeleccionMano() {
        this.mano.eliminarCoincidenciasSeleccionMano();
    }
    
}
