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

    private final Map<Socket, Jugador> jugadorSocketMap;
    private Jugador jugadorActual;

    public FachadaGraficaCore() {
        this.jugadorSocketMap = new HashMap<>();
    }

    @Override
    public void crearJugador(String nombre, String avatar, List<Color> colores) {
        Jugador jugador = new Jugador();
        jugador.setAvatar(avatar);
        jugador.setNombre(nombre);
        this.setJugadorActual(jugador);
    }

    public synchronized void registrarJugador(Socket socket, Jugador jugador) {
        jugadorSocketMap.put(socket, jugador);
        System.out.println("Jugador registrado: " + jugador.getNombre());
        System.out.println(jugadorSocketMap);
    }

    public synchronized void removerJugador(Socket socket) {
        if (jugadorSocketMap.remove(socket) != null) {
            jugadorSocketMap.remove(socket);
            System.out.println("Jugador removido");
            System.out.println(jugadorSocketMap);
        }

    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

}
