/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dtos.RespuestaDTO;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carli
 */
public class Comunicacion implements IComunicacionPlugin {

    public List<IComunicacionCliente> comunicacionClientes;

    public Comunicacion() {
        this.comunicacionClientes = new ArrayList<>();
    }

    @Override
    public synchronized void transmitirMensaje(RespuestaDTO respuesta) {
        // Envía un mensaje a todos los clientes registrados.
        for (IComunicacionCliente cliente : comunicacionClientes) {
            cliente.mandarMensaje(respuesta);
        }
    }

    @Override
    public synchronized void transmitirALosDemas(Socket cliente, RespuestaDTO respuesta) {
        // Envía un mensaje a todos los clientes excepto al especificado.
        for (IComunicacionCliente comunicacionCliente : comunicacionClientes) {
            if (!comunicacionCliente.getClientSocket().equals(cliente)) {
                comunicacionCliente.mandarMensaje(respuesta);
            }
        }
    }

    @Override
    public synchronized void suscribirCliente(IComunicacionCliente cliente) {
        comunicacionClientes.add(cliente);
        cliente.mandarMensaje(new RespuestaDTO("SUSCRIBIR_CLIENTE", true, "Cliente Suscrito"));
        System.out.println(comunicacionClientes);
    }

    @Override
    public synchronized void removerCliente(IComunicacionCliente cliente) {
        comunicacionClientes.remove(cliente);
        cliente.mandarMensaje(new RespuestaDTO("REMOVER_CLIENTE", true, "Cliente Removido"));
        System.out.println(comunicacionClientes);

    }

    @Override
    public synchronized void transmitirACliente(Socket cliente, RespuestaDTO respuesta) {
        // Envía un mensaje a un cliente específico basado en su socket.
        for (IComunicacionCliente comunicacionCliente : comunicacionClientes) {
            if (comunicacionCliente.getClientSocket().equals(cliente)) {
                comunicacionCliente.mandarMensaje(respuesta);
                break;
            }
        }
    }

}
