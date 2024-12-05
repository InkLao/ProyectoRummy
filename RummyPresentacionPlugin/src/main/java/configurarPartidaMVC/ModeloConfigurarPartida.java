/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurarPartidaMVC;

import comunicacion.FachadaCore;
import dtos.RespuestaDTO;

/**
 *
 * @author carli
 */
public class ModeloConfigurarPartida implements IModeloConfigurarPartida, ObservadorModeloConfiguracion {

    ObservadorConfiguracion observadorConfiguracion;
    private int rango;
    private int numeroComodines;    
    private boolean visible;
    private boolean estado;
    private FachadaCore core;
    
    public ModeloConfigurarPartida(FachadaCore core) {
        this.core = core;
    }
    
    @Override
    public void actualizarModeloConfiguracion(RespuestaDTO respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public boolean isEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public void setNumeroComodines(int numeroComodines) {
        this.numeroComodines = numeroComodines;
    }
  
    public void notificar() {
        observadorConfiguracion.actualizar(this);
    }

    public void notificarError(String mensaje) {
        if (observadorConfiguracion != null) {
            observadorConfiguracion.mostrarError(mensaje);
        }
    }
    
    public void notificarMensaje(String mensaje) {
        if (observadorConfiguracion != null) {
            observadorConfiguracion.mostrarMensaje(mensaje);
        }
    }
    
}
