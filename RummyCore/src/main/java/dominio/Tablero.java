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
public class Tablero {
    
    private List<GrupoFichas> grupos;

    public Tablero() {
    }

    public Tablero(List<GrupoFichas> fichasTablero) {
        this.grupos = fichasTablero;
    }

    public List<GrupoFichas> getFichasTablero() {
        return grupos;
    }

    public void setFichasTablero(List<GrupoFichas> fichasTablero) {
        this.grupos = fichasTablero;
    }

    public boolean eliminarCoincidenciasSeleccionTablero(List<Ficha> seleccion) {
        
        // bandera indica alguno de los grupos ha sido cortado por el jugador
        boolean grupoCortado = false;
        
        // eliminar coincidencias
        for (Ficha ficha: seleccion) {
            // si la ficha de la selección se encuentra en alguno de los grupos del tablero, se elimina
            for (GrupoFichas grupo: this.grupos) {
                // se obtienen las fichas del grupo actual (el grupo iterado de los del tablero)
                Iterator<Ficha> iterator = grupo.getFichas().iterator();
                // si hay una ficha por inspeccionar (verificar la coincidencia con las fichas de la selección)
                while (iterator.hasNext()) {
                    // se obtiene la ficha por verificar la coincidencia
                    Ficha fichaGrupo = iterator.next();
                    // verificar coincidencia por código (puesto que puede ser ficha numérica o comodín)
                    if (fichaGrupo.getCodigo() == ficha.getCodigo()) {
                        // se elimina la ficha del grupo al que pertenecía
                        iterator.remove();
                        
                        // esto quiere decir que el grupo fue cortado
                        grupoCortado = true;
                    }
                }
            }
        }
        
        
        // eliminar grupos vacios
        Iterator<GrupoFichas> iterador = this.grupos.iterator();
        // si hay un grupo por inspeccionar
        while (iterador.hasNext()) {
            // se obtiene el grupo por inspeccionar (grupo por verificar si está vacío)
            GrupoFichas grupo = iterador.next();
            // si el grupo está vacío
            if (grupo.getFichas().isEmpty()) {
                // se elimina el grupo del tablero, puesto que ya no contiene fichas
                iterador.remove();
            }
        }
        
        // devuelve como respuesta si alguno de los grupos fue cortado
        return grupoCortado;
    }

    public void agregarGrupo(GrupoFichas grupo) {
        this.grupos.add(grupo);
    }

    public boolean validarGrupos() {
        // si alguno de los grupos del tablero es invalido, retorna falso, verdadero en caso contrario
        for (GrupoFichas grupo: this.grupos) {
            if (grupo.getTipo() == TipoGrupo.INVALIDO) {
                return false;
            }
        }
        return true;
    }
}
