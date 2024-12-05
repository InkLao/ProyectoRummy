/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.Iterator;
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

    void eliminarCoincidenciasSeleccionMano(List<Ficha> seleccion) {
        // selecciona una ficha de seleccion
        for (Ficha fichaSeleccion: seleccion) {
            Iterator<Ficha> iterador = this.fichas.iterator();
            while (iterador.hasNext()) {
                // selecciona una ficha de la mano
                Ficha fichaMano = iterador.next();
                // si la ficha de la mano coincide con la de la seleccion
                if (fichaMano.getCodigo() == fichaSeleccion.getCodigo()) {
                    // la ficha se elimina de la mano
                    iterador.remove();
                }
            }
        }
    }
    
    public void agregarFicha(Ficha ficha) {
        this.fichas.add(ficha);
    }
    
}
