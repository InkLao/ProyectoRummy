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
 public List<Socket> comunicacionClientes;

    public Comunicacion() {
        comunicacionClientes= new ArrayList<>();
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
    public void suscribirCliente(Socket cliente) {
        comunicacionClientes.add(cliente);
        System.out.println(comunicacionClientes);
    }

    @Override
    public void removerCliente(Socket cliente) {
        comunicacionClientes.remove(cliente);
        System.out.println(comunicacionClientes);
    }

    @Override
    public void transmitirACliente(Socket cliente, RespuestaDTO respuesta) {
        
    }
    
}
