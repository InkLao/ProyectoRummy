/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dtos.MensajeDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carli
 */
public class Comunicacion implements IComunicacionPlugin {
 public List<IComunicacionCliente> comunicacionClientes;

    public Comunicacion() {
        comunicacionClientes= new ArrayList<>();
    }
 
 
 
    @Override
    public void transmitirMensaje(MensajeDTO mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void transmitirALosDemas(String idCliente, MensajeDTO mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suscribirCliente(IComunicacionCliente cliente) {
        comunicacionClientes.add(cliente);
        System.out.println(comunicacionClientes);
    }

    @Override
    public void removerCliente(IComunicacionCliente cliente) {
        comunicacionClientes.remove(cliente);
        System.out.println(comunicacionClientes);
    }

    @Override
    public void transmitirACliente(IComunicacionCliente cliente, MensajeDTO mensaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
