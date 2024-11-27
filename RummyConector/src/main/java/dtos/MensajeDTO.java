/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author carli
 */
public class MensajeDTO implements Serializable {
    private String accion;
    private Object dto;

    public MensajeDTO(String accion, Object dto) {
        this.accion = accion;
        this.dto = dto;
    }

    public MensajeDTO(String accion) {
        this.accion = accion;
    }

    public Object getDto() {
        return dto;
    }

    public void setDto(Object dto) {
        this.dto = dto;
    }

    
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
    
}
