/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comunicacion;

import dtos.RespuestaDTO;
import java.net.Socket;

/**
 *
 * @author carli
 */
public interface IComunicacionCliente {
  public void mandarMensaje(RespuestaDTO respuesta);
      public Socket getClientSocket() ;

}
