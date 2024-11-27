/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comunicacion;

import dtos.MensajeDTO;

/**
 *
 * @author carli
 */
public interface IComunicacionPlugin {

    public void transmitirMensaje(MensajeDTO mensaje);

    public void transmitirALosDemas(String idCliente, MensajeDTO mensaje);

    public void suscribirCliente(IComunicacionCliente cliente);

    public void removerCliente(IComunicacionCliente cliente);

    public void transmitirACliente(IComunicacionCliente cliente, MensajeDTO mensaje);
}
