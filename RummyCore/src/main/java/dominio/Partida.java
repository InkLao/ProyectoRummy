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

    // LOGICA
    public void colocarGrupo(List<Ficha> seleccion) {

        // si hay fichas seleccionadas
        if (!seleccion.isEmpty()) {

            // crear nuevo grupo por colocar
            GrupoFichas grupoPorColocar = new GrupoFichas();

            // si la ficha seleccionada pertenece al tablero se moverá (se eliminara y se colocará después en el nuevo grupo)
            // si se eliminó alguna coincidencia, quiere decir que un grupo fue cortado por el jugador
            this.controlTurnos.setGrupoCortado(this.tablero.eliminarCoincidenciasSeleccionTablero(seleccion));

            // cada ficha seleccionada se agregará al grupo y se incrementará la puntuación del jugador por cada ficha colocada
            for (Ficha ficha : seleccion) {

                // se agrega la ficha seleccionada al grupo
                grupoPorColocar.agregarFicha();

                // se incrementa la puntuación del jugador por la ficha colocada
                if (ficha instanceof FichaNumerica) { // si la ficha es numerica
                    FichaNumerica fichaNumerica = (FichaNumerica) ficha;
                    this.controlTurnos.incrementarPuntuacion(fichaNumerica.getNumero());
                } else {
                    // tal vez incrementar un valor por defecto del comodin
                }
            }

            // se clasifica el grupo creado (terna, cuaterna, escalera o inválido)
            grupoPorColocar.clasificarGrupo();

            // se agrega el grupo al tablero
            this.tablero.agregarGrupo();

            // se eliminan las fichas que se seleccionaron de la mano para colocarlas en el grupo (se elimina la referencia de la mano a la ficha, no la ficha)
            this.controlTurnos.eliminarCoincidenciasSeleccionMano();

        }
    }

}
