/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import comunicacion.InterfazGraficaPlugin;
import java.awt.Color;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author carli
 */
public class FachadaGraficaCore implements InterfazGraficaPlugin {

    private final Map<Socket, Jugador> jugadoresRegistrados;
    private List<Jugador>  jugadoresEnPartida  ;
    private Jugador jugadorActual;
    private Partida partida;

    public FachadaGraficaCore() {
        this.jugadoresRegistrados = new HashMap<>();
    }

    @Override
    public void crearJugador(String nombre, String avatar, List<Color> colores) {
        Jugador jugador = new Jugador();
        jugador.setAvatar(avatar);
        jugador.setNombre(nombre);
        this.setJugadorActual(jugador);
    }

    public synchronized void registrarJugador(Socket socket, Jugador jugador) {
        jugadoresRegistrados.put(socket, jugador);
        System.out.println("Jugador registrado: " + jugador.getNombre());
        System.out.println(jugadoresRegistrados);
    }

    public synchronized void removerJugador(Socket socket) {
        if (jugadoresRegistrados.remove(socket) != null) {
            jugadoresRegistrados.remove(socket);
            System.out.println("Jugador removido");
            System.out.println(jugadoresRegistrados);
        }

    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    @Override
    public void encontrarPartida() {
        this.partida.getEstado();
    }

    @Override
    public void enviarConfiguracionPartida(int rango, int numeroComodines) {
        if (partida == null) {
            partida = new Partida("DISPONIBLE", numeroComodines, rango);
            System.out.println(this.partida.toString());
        } else {
            partida.setEstado("DISPONIBLE");
            partida.setNumeroComodines(numeroComodines);
            partida.setRangoFichas(rango);
            System.out.println(this.partida.toString());

        }

    }

}
