/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comunicacion;

import dtos.RespuestaDTO;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author carli
 */
public interface IComunicacionPlugin {

    public void transmitirMensaje(RespuestaDTO respuesta);

    public void transmitirALosDemas(Socket cliente, RespuestaDTO respuesta);

    public void suscribirCliente(IComunicacionCliente cliente);

    public void removerCliente(IComunicacionCliente cliente);

    public void transmitirACliente(Socket cliente, RespuestaDTO respuesta);
    
        

}
