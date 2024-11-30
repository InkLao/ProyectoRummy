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
public class GrupoFichas {
    
    private List<Ficha> fichas;
    private TipoGrupo tipo;

    public GrupoFichas() {
    }

    public GrupoFichas(List<Ficha> fichas, TipoGrupo tipo) {
        this.fichas = fichas;
        this.tipo = tipo;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public TipoGrupo getTipo() {
        return tipo;
    }

    public void setTipo(TipoGrupo tipo) {
        this.tipo = tipo;
    }

    void agregarFicha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void clasificarGrupo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
