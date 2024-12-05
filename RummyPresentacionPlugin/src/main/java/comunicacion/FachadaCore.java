/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dtos.MensajeDTO;
import dtos.ModeloConfiguracionDTO;
import dtos.ModeloRegistroDTO;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author carli
 */
public class FachadaCore implements InterfazGraficaPlugin {

    ClienteSocket socket;

    public FachadaCore(ClienteSocket socket) {
        this.socket = socket;
    }

    @Override
    public void crearJugador(String nombre, String avatar, List<Color> colores) {
        MensajeDTO mensajeDTO = new MensajeDTO("REGISTRAR_JUGADOR", new ModeloRegistroDTO(avatar, colores, nombre));
        socket.mandarMensaje(mensajeDTO);
    }

    @Override
    public void encontrarPartida() {
        MensajeDTO mensajeDTO = new MensajeDTO("ENCONTRAR_PARTIDA");
        socket.mandarMensaje(mensajeDTO);
    }

    @Override
    public void enviarConfiguracionPartida(int rango, int numeroComodines) {
        MensajeDTO mensajeDTO = new MensajeDTO("CONFIGURAR_PARTIDA",new ModeloConfiguracionDTO(rango, numeroComodines));
        socket.mandarMensaje(mensajeDTO);
    }

}
