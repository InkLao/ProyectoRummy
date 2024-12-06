/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import configurarPartidaMVC.ObservadorModeloConfiguracion;
import dtos.ModeloConfiguracionDTO;
import dtos.ModeloRegistroDTO;
import dtos.RespuestaDTO;
import registrarJugadorMVC.ObservadorModeloRegistro;

/**
 *
 * @author carli
 */
public class Notificador {

    ObservadorModeloRegistro modeloRegistro;
    ObservadorModeloConfiguracion modeloConfiguracion;
    RespuestaDTO respuestaDTO;

    public Notificador(ObservadorModeloRegistro modeloRegistro, ObservadorModeloConfiguracion modeloConfiguracion) {
        this.modeloRegistro = modeloRegistro;
        this.modeloConfiguracion=modeloConfiguracion;
    }

    public void setRespuestaDTO(RespuestaDTO respuestaDTO) {
        this.respuestaDTO = respuestaDTO;
        this.notificarATodos();
    }
    
    

    public void notificarATodos() {
        if (respuestaDTO.getDatos() instanceof ModeloRegistroDTO) {
            modeloRegistro.actualizarModeloRegistro(respuestaDTO);

        }
         if (respuestaDTO.getDatos() instanceof ModeloConfiguracionDTO) {
            modeloConfiguracion.actualizarModeloConfiguracion(respuestaDTO);

        }
    }
}
