/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurarPartidaMVC;

import comunicacion.FachadaCore;
import dtos.ModeloConfiguracionDTO;
import dtos.RespuestaDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carli
 */
public class ModeloConfigurarPartida implements IModeloConfigurarPartida, ObservadorModeloConfiguracion {

    ObservadorConfiguracion observadorConfiguracion;
    private int rangoFichas;
    private int numeroComodines;
    private boolean visible;
    private boolean estado;
    private FachadaCore core;
    private List<String> rangosDisponibles;

    public ModeloConfigurarPartida(FachadaCore core) {
        this.core = core;
        rangosDisponibles = new ArrayList<>();
        this.setRangosDisponibles();
    }

    @Override
    public void actualizarModeloConfiguracion(RespuestaDTO respuesta) {
        if (!respuesta.isExito()) {
            this.notificarError(respuesta.getMensaje());
        }
        ModeloConfiguracionDTO modeloRegistroDTO = (ModeloConfiguracionDTO) respuesta.getDatos();
        this.rangoFichas = modeloRegistroDTO.getRangoFichas();
        this.numeroComodines = modeloRegistroDTO.getNumeroComodines();
        this.notificar();
        this.notificarMensaje(respuesta.getMensaje());
    }

    @Override
    public List<String> getRangosDisponibles() {
        return rangosDisponibles;
    }

    public void setRangosDisponibles() {
        rangosDisponibles.add("1-10");
        rangosDisponibles.add("1-13");
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

    public void asignarConfiguracionPartida() {
        try {
            core.enviarConfiguracionPartida(rangoFichas, numeroComodines);
        } catch (IllegalArgumentException ex) {
            this.notificarError(ex.getMessage());
        } catch (IOException ex) {
            this.notificarError(ex.getMessage());
        }
    }

    public void validarDatos() {
        try {
            if (numeroComodines < 2) {
                throw new IllegalArgumentException("El número de comodines no puede ser menor a 2.");
            }
            if (numeroComodines > 8) {  // Aquí asumimos que el número máximo de comodines es 10, pero ajusta según sea necesario.
                throw new IllegalArgumentException("El número de comodines no puede ser mayor 8.");
            }

            // Validar rangoFichas
            if (rangoFichas != 10 && rangoFichas != 13) {  // Asumimos que el rango de fichas es entre 1 y 100.
                throw new IllegalArgumentException("El rango de fichas no es valido.");
            }
        } catch (IllegalArgumentException e) {
            setEstado(false);
            notificarError(e.getMessage());
        }
    }

    public int getRangoFichas() {
        return rangoFichas;
    }

    public void setRangoFichas(int rangoFichas) {
        this.rangoFichas = rangoFichas;
    }

    public ObservadorConfiguracion getObservadorConfiguracion() {
        return observadorConfiguracion;
    }

    public void setObservadorConfiguracion(ObservadorConfiguracion observadorConfiguracion) {
        this.observadorConfiguracion = observadorConfiguracion;
    }

}
