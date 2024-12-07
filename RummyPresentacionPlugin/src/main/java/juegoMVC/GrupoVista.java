/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoMVC;

import java.util.List;

/**
 *
 * @author marlon
 */
class GrupoVista {
    
    private List<FichaVista> fichas;

    public GrupoVista() {
    }

    public GrupoVista(List<FichaVista> fichas) {
        this.fichas = fichas;
    }

    public List<FichaVista> getFichas() {
        return fichas;
    }

    public void setFichas(List<FichaVista> fichas) {
        this.fichas = fichas;
    }
    
}
