/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dominio.FachadaGraficaCore;
import dtos.JugadorDTO;
import dtos.MensajeDTO;
import dtos.ModeloRegistroDTO;
import dtos.RespuestaDTO;
import java.net.Socket;

/**
 *
 * @author carli
 */
public class Protocolo {

    private FachadaGraficaCore fachadaGraficaCore; // Interacción con el núcleo del sistema
    private IComunicacionPlugin comunicacionPlugin;
    private Socket socketActual;

    public Protocolo(FachadaGraficaCore fachadaGraficaCore, IComunicacionPlugin comunicacionPlugin) {
        this.fachadaGraficaCore = fachadaGraficaCore;
        this.comunicacionPlugin = comunicacionPlugin;
    }

    public void ejecutarAccion(ManejadorCliente manejadorCliente, MensajeDTO mensaje) {
        if (mensaje == null || mensaje.getAccion() == null) {
            enviarError(manejadorCliente.getClientSocket(), "Mensaje o acción no puede ser nula.");
            return;
        }

        String accion = mensaje.getAccion().toUpperCase(); // Normalize action string
        System.out.println("Acción recibida: " + accion);

        try {
            switch (accion) {
                case "SUSCRIBIR_CLIENTE":
                    suscribirCliente(manejadorCliente);
                    break;
                case "REMOVER_CLIENTE":
                    removerCliente(manejadorCliente);
                    break;
                case "REGISTRAR_JUGADOR":
                    registrarJugador(manejadorCliente.getClientSocket(), mensaje);
                    break;
                case "CONFIGURAR_PARTIDA":
                    configurarPartida(manejadorCliente.getClientSocket(), mensaje);
                    break;
                case "INICIAR_PARTIDA":
                    iniciarPartida(manejadorCliente.getClientSocket(), mensaje);
                    break;
                case "JUGAR_TURNO":
                    ejecutarTurno(manejadorCliente.getClientSocket(), mensaje);
                    break;
                default:
                    enviarError(manejadorCliente.getClientSocket(), "Acción no reconocida: " + accion);
            }
        } catch (Exception e) {
            enviarError(manejadorCliente.getClientSocket(), "Error interno del servidor al procesar la acción.");
            e.printStackTrace(); // For debugging
        }
    }
    // Métodos para manejar acciones específicas

    private void registrarJugador(Socket cliente, MensajeDTO mensaje) {
        this.socketActual = cliente;
        ModeloRegistroDTO jugadorDTO = (ModeloRegistroDTO) mensaje.getDto();
        fachadaGraficaCore.crearJugador(jugadorDTO.getNombre(), jugadorDTO.getAvatar(), jugadorDTO.getColores());
        fachadaGraficaCore.registrarJugador(cliente, fachadaGraficaCore.getJugadorActual());
        System.out.println("Jugador mandado a registrarse");

//        boolean resultado = fachadaCore.registrarJugador(jugadorDTO);
        comunicacionPlugin.transmitirACliente(cliente, new RespuestaDTO(mensaje.getAccion(), true, "Exito al registrar al jugador", jugadorDTO));
    }

    private void configurarPartida(Socket cliente, MensajeDTO mensaje) {
//        ConfiguracionPartidaDTO configuracionDTO = (ConfiguracionPartidaDTO) mensaje.getContenido();
//        boolean resultado = fachadaCore.configurarPartida(configuracionDTO);
//        cliente.enviarMensaje(new RespuestaDTO("CONFIGURAR_PARTIDA", resultado));
    }

    private void iniciarPartida(Socket cliente, MensajeDTO mensaje) {
//        boolean resultado = fachadaCore.iniciarPartida();
//        cliente.enviarMensaje(new RespuestaDTO("INICIAR_PARTIDA", resultado));
    }

    private void ejecutarTurno(Socket cliente, MensajeDTO mensaje) {
//        TurnoDTO turnoDTO = (TurnoDTO) mensaje.getContenido();
//        boolean resultado = fachadaCore.ejecutarTurno(turnoDTO);
//        cliente.enviarMensaje(new RespuestaDTO("JUGAR_TURNO", resultado));
    }

    private void suscribirCliente(ManejadorCliente manejadorCliente) {
        comunicacionPlugin.suscribirCliente(manejadorCliente);
        System.out.println("cliente mandado a suscribir");
    }

    private void removerCliente(ManejadorCliente manejadorCliente) {
        fachadaGraficaCore.removerJugador(socketActual);
        comunicacionPlugin.removerCliente(manejadorCliente);
        System.out.println("cliente mandado a remover");
    }

    // Método para manejar errores y enviar respuesta al cliente
    private void enviarError(Socket cliente, String errorMensaje) {
        comunicacionPlugin.transmitirACliente(cliente, new RespuestaDTO("ERROR", false, errorMensaje));
    }

}
