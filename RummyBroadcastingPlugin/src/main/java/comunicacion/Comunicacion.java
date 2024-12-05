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
    public void transmitirMensaje(RespuestaDTO respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void transmitirALosDemas(Socket cliente, RespuestaDTO respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suscribirCliente(IComunicacionCliente cliente) {
        comunicacionClientes.add(cliente);
        cliente.mandarMensaje(new RespuestaDTO("SUSCRIBIR_CLIENTE", true, "Cliente Suscrito"));
        System.out.println(comunicacionClientes);
    }

    @Override
    public void removerCliente(IComunicacionCliente cliente) {
        comunicacionClientes.remove(cliente);
        cliente.mandarMensaje(new RespuestaDTO("REMOVER_CLIENTE", true, "Cliente Removido"));
                System.out.println(comunicacionClientes);

    }

    @Override
    public void transmitirACliente(Socket cliente, RespuestaDTO respuesta) {

    }

  
}
