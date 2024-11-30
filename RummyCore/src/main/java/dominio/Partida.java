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
    
    private ControlTurnos controlTurnos;
    private String estado;
    private PozoFichas pozo;
    private Tablero tablero;

    public Partida() {
    }
    
    public Partida(ControlTurnos controlTurnos, String estado, PozoFichas pozo, Tablero tablero) {
        this.controlTurnos = controlTurnos;
        this.estado = estado;
        this.pozo = pozo;
        this.tablero = tablero;
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
