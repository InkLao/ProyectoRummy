/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dtos.ModeloRegistroDTO;
import dtos.RespuestaDTO;
import registrarJugadorMVC.ObservadorModeloRegistro;

/**
 *
 * @author carli
 */
public class Notificador {

    ObservadorModeloRegistro modeloRegistro;
    RespuestaDTO respuestaDTO;

    public void notificarATodos() {
        if (respuestaDTO.getDatos() instanceof ModeloRegistroDTO) {
            modeloRegistro.actualizarModeloRegistro((ModeloRegistroDTO) respuestaDTO.getDatos());

        }
    }
}
