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
public class Tablero {
    
    private List<GruposFichas> fichasTablero;

    public Tablero() {
    }

    public Tablero(List<GruposFichas> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }

    public List<GruposFichas> getFichasTablero() {
        return fichasTablero;
    }

    public void setFichasTablero(List<GruposFichas> fichasTablero) {
        this.fichasTablero = fichasTablero;
    }
}
