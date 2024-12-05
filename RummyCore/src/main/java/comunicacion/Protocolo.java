/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dominio.FachadaGraficaCore;
import dtos.MensajeDTO;
import dtos.RespuestaDTO;
import java.net.Socket;

/**
 *
 * @author carli
 */
public class Protocolo {

    private FachadaGraficaCore fachadaGraficaCore; // Interacción con el núcleo del sistema
    private IComunicacionPlugin comunicacionPlugin;

    public Protocolo(FachadaGraficaCore fachadaGraficaCore, IComunicacionPlugin comunicacionPlugin) {
        this.fachadaGraficaCore = fachadaGraficaCore;
        this.comunicacionPlugin = comunicacionPlugin;
    }

    public void ejecutarAccion(Socket cliente, MensajeDTO mensaje) {
        if (mensaje == null || mensaje.getAccion() == null) {
            enviarError(cliente, "Mensaje o acción no puede ser nula.");
            return;
        }

        String accion = mensaje.getAccion().toUpperCase(); // Normalize action string
        System.out.println("Acción recibida: " + accion);

        try {
            switch (accion) {
                case "SUSCRIBIR_CLIENTE":
                    suscribirCliente(cliente);
                    break;
                case "REMOVER_CLIENTE":
                    removerCliente(cliente);
                    break;
                case "REGISTRAR_JUGADOR":
                    registrarJugador(cliente, mensaje);
                    break;
                case "CONFIGURAR_PARTIDA":
                    configurarPartida(cliente, mensaje);
                    break;
                case "INICIAR_PARTIDA":
                    iniciarPartida(cliente, mensaje);
                    break;
                case "JUGAR_TURNO":
                    ejecutarTurno(cliente, mensaje);
                    break;
                default:
                    enviarError(cliente, "Acción no reconocida: " + accion);
            }
        } catch (Exception e) {
            enviarError(cliente, "Error interno del servidor al procesar la acción.");
            e.printStackTrace(); // For debugging
        }
    }
    // Métodos para manejar acciones específicas

    private void registrarJugador(Socket cliente, MensajeDTO mensaje) {
//        JugadorDTO jugadorDTO = (JugadorDTO) mensaje.getContenido();
//        boolean resultado = fachadaCore.registrarJugador(jugadorDTO);
//        cliente.enviarMensaje(new RespuestaDTO("REGISTRAR_JUGADOR", resultado));
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

    private void suscribirCliente(Socket cliente) {
        comunicacionPlugin.suscribirCliente(cliente);
        System.out.println("cliente mandado a suscribir");
    }

    private void removerCliente(Socket cliente) {
        comunicacionPlugin.removerCliente(cliente);
        System.out.println("cliente mandado a remover");
    }

    // Método para manejar errores y enviar respuesta al cliente
    private void enviarError(Socket cliente, String errorMensaje) {
        comunicacionPlugin.transmitirACliente(cliente,new RespuestaDTO("ERROR", false, errorMensaje));
    }

}
