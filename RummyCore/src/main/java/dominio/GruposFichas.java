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
public class GruposFichas {
    
    private List<Ficha> grupoFicha;
    private TipoGrupo tipo;

    public GruposFichas() {
    }

    public GruposFichas(List<Ficha> grupoFicha, TipoGrupo tipo) {
        this.grupoFicha = grupoFicha;
        this.tipo = tipo;
    }

    public List<Ficha> getGrupoFicha() {
        return grupoFicha;
    }

    public void setGrupoFicha(List<Ficha> grupoFicha) {
        this.grupoFicha = grupoFicha;
    }

    public TipoGrupo getTipo() {
        return tipo;
    }

    public void setTipo(TipoGrupo tipo) {
        this.tipo = tipo;
    }
    
}
