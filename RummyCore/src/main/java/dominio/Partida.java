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
    private int numeroComodines;
    private int rangoFichas;

    public Partida() {
        controlTurnos = new ControlTurnos();
        pozo = new PozoFichas();
        tablero = new Tablero();
    }

    public Partida(ControlTurnos controlTurnos, String estado, PozoFichas pozo, Tablero tablero, int numeroComodines, int rangoFichas) {
        this.controlTurnos = controlTurnos;
        this.estado = estado;
        this.pozo = pozo;
        this.tablero = tablero;
        this.numeroComodines = numeroComodines;
        this.rangoFichas = rangoFichas;
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

    public ControlTurnos getControlTurnos() {
        return controlTurnos;
    }

    public void setControlTurnos(ControlTurnos controlTurnos) {
        this.controlTurnos = controlTurnos;
    }

    public int getNumeroComodines() {
        return numeroComodines;
    }

    public void setNumeroComodines(int numeroComodines) {
        this.numeroComodines = numeroComodines;
    }

    public int getRangoFichas() {
        return rangoFichas;
    }

    public void setRangoFichas(int rangoFichas) {
        this.rangoFichas = rangoFichas;
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
                grupoPorColocar.agregarFicha(ficha);

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
            this.tablero.agregarGrupo(grupoPorColocar);

            // se eliminan las fichas que se seleccionaron de la mano para colocarlas en el grupo (se elimina la referencia de la mano a la ficha, no la ficha)
            this.controlTurnos.eliminarCoincidenciasSeleccionMano(seleccion);

        }
    }

    public void validarGruposTablero() {
        this.tablero.validarGrupos();
    }

    public boolean validarTiradaJugador() {
        // bandera que indica si la tirada del jugador es válida
        boolean tiradaValida = true;

        Jugador jugadorActual = this.controlTurnos.obtenerJugadorActual();

        // si un grupo fue cortado y el judaro no ha realizado la tirada inicial
        if (this.controlTurnos.isGrupoCortado() && jugadorActual.isTiradaInicial()) {
            // se invalida el movimiento, porque el jugador no debe cortar turnos en la tirada inicial
            tiradaValida = false;
        }

        // si el jugador no alcanzó los 30 puntos y es la tirada inicial
        if (jugadorActual.getPuntaje() < 30 && jugadorActual.isTiradaInicial()) {
            // se invalida el movimiento, porque para que la tirada inicial sea válida debe alcanzar los 30 puntos
            tiradaValida = false;
        }

        return tiradaValida;
    }

    public void pasarTurno() {
        this.controlTurnos.pasarTurno();
    }

    public void jalarFicha() {
        this.pozo.jalarFicha();
    }

    public void agregarFichaMano(Ficha ficha) {
        this.controlTurnos.agregarFichaMano(ficha);
    }

}
