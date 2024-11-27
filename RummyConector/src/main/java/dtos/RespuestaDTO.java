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
public class RespuestaDTO implements Serializable {

    private String tipoAccion; // Tipo de acción que generó la respuesta
    private boolean exito;     // Resultado de la operación: true si fue exitosa, false si no
    private String mensaje;    // Mensaje opcional (puede ser un error o una confirmación)
    private Object datos;      // Datos adicionales relevantes para el cliente (opcional)

    // Constructores
    public RespuestaDTO(String tipoAccion, boolean exito) {
        this.tipoAccion = tipoAccion;
        this.exito = exito;
    }

    public RespuestaDTO(String tipoAccion, boolean exito, String mensaje) {
        this.tipoAccion = tipoAccion;
        this.exito = exito;
        this.mensaje = mensaje;
    }

    public RespuestaDTO(String tipoAccion, boolean exito, String mensaje, Object datos) {
        this.tipoAccion = tipoAccion;
        this.exito = exito;
        this.mensaje = mensaje;
        this.datos = datos;
    }

    // Getters y Setters
    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public boolean isExito() {
        return exito;
    }

    public void setExito(boolean exito) {
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getDatos() {
        return datos;
    }

    public void setDatos(Object datos) {
        this.datos = datos;
    }

    // Representación en String para debug
    @Override
    public String toString() {
        return "RespuestaDTO{"
                + "tipoAccion='" + tipoAccion + '\''
                + ", exito=" + exito
                + ", mensaje='" + mensaje + '\''
                + ", datos=" + datos
                + '}';
    }
}
