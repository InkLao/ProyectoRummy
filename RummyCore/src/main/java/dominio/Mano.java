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
public class Mano {
    
    private List<Ficha> fichas;
    private List<Ficha> estadoInicial;

    public Mano() {
    }

    public Mano(List<Ficha> fichas, List<Ficha> estadoInicial) {
        this.fichas = fichas;
        this.estadoInicial = estadoInicial;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public List<Ficha> getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(List<Ficha> estadoInicial) {
        this.estadoInicial = estadoInicial;
    }
    
}
