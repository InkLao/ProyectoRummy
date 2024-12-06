/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarJugadorMVC;

import comunicacion.FachadaCore;
import dtos.ModeloRegistroDTO;
import dtos.RespuestaDTO;
import java.awt.Color;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class ModeloRegistro implements IModeloRegistro, ObservadorModeloRegistro {

    private ObservadorRegistro observadorRegistro;
    private FachadaCore core;
    private String nombre;
    private String rutaAvatar;
    private String rutaAvatarAgrandado;
    private List<ImageIcon> listaAvatars;
    private List<Color> colores;
    private boolean visible;
    private boolean estado;

    public ModeloRegistro(FachadaCore core) {
        this.core = core;
        this.nombre="";
        this.listaAvatars = new ArrayList<>();
        this.colores = new ArrayList<>();
        this.estado = true;
        this.visible=false;
        this.setColores();
        this.setListaAvatars();
    }

    @Override
    public List<Color> getColores() {
        return colores;
    }

    public void setListaAvatars() {
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/knight.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/frankestein.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/spock.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/wizard.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/ponyTailWoman.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/spikedHairWoman.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/shortHairWoman.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/studentWoman.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/mexicanMan.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/afroAmericanMan.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/moustacheMan.png")));
        listaAvatars.add(new ImageIcon(getClass().getResource("/avatars/hippieMan.png")));

    }

    public void setColores() {
        colores.add(Color.BLACK);
        colores.add(Color.RED);
        colores.add(Color.GREEN);
        colores.add(Color.BLUE);
    }

    @Override
    public String getRutaAvatarAgrandado() {
        return rutaAvatarAgrandado;
    }

    public void setRutaAvatarAgrandado() {
        int indicePunto = rutaAvatar.lastIndexOf(".");
        String rutaAvatarSeleccionado;
        rutaAvatarSeleccionado = rutaAvatar.substring(0, indicePunto) + "2" + rutaAvatar.substring(indicePunto);
        rutaAvatarSeleccionado = extractRelativePath(rutaAvatarSeleccionado);
        System.out.println(rutaAvatarSeleccionado);
        this.rutaAvatarAgrandado = rutaAvatarSeleccionado;
        this.notificar();
    }

    public void cambiarColor(int index, Color color) {
        colores.set(index, color);
        this.notificar();

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        this.notificar();
    }

    public static String extractRelativePath(String fullPath) {
        // Buscar el índice de "classes/"
        int index = fullPath.indexOf("classes");
        if (index != -1) {
            return fullPath.substring(index + "classes".length());
        }
        return "";  // Retornar vacío si no se encontró "classes/"
    }

    public ObservadorRegistro getObservadorRegistro() {
        return observadorRegistro;
    }

    public void setObservadorRegistro(ObservadorRegistro observadorRegistro) {
        this.observadorRegistro = observadorRegistro;
    }

    @Override
    public List<ImageIcon> getListaAvatars() {
        return listaAvatars;
    }

    public String getRutaAvatar() {
        return rutaAvatar;
    }

    public void setRutaAvatar(String rutaAvatar) {
        this.rutaAvatar = rutaAvatar;
    }

    @Override
    public boolean getVisible() {
        return visible;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setVisible(boolean visble) {
        this.visible = visble;
        this.notificar();

    }

    public void notificar() {
        observadorRegistro.actualizar((IModeloRegistro) this);
    }

    @Override
    public void actualizarModeloRegistro(RespuestaDTO respuesta) {
        if (!respuesta.isExito()) {
            this.notificarError(respuesta.getMensaje());
            this.setEstado(false);
            return;
        }

        ModeloRegistroDTO modeloRegistroDTO = (ModeloRegistroDTO) respuesta.getDatos();
        this.colores = modeloRegistroDTO.getColores();
        this.nombre = modeloRegistroDTO.getNombre();
        this.rutaAvatar = modeloRegistroDTO.getAvatar();
        this.setRutaAvatarAgrandado();
        this.notificar();
        this.notificarMensaje(respuesta.getMensaje());
    }

    public void registrarJugador() {
        try {
            core.crearJugador(nombre, rutaAvatar, colores);
        } catch (IllegalArgumentException ex) {
            this.notificarError(ex.getMessage());
        } catch (IOException ex) {
            this.notificarError(ex.getMessage());
        }
    }

    public void notificarError(String mensaje) {
        if (observadorRegistro != null) {
            observadorRegistro.mostrarError(mensaje);
        }
    }

    public void notificarMensaje(String mensaje) {
        if (observadorRegistro != null) {
            observadorRegistro.mostrarMensaje(mensaje);
        }
    }

    public void validarDatos() {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }
            if (nombre.length() < 3 || nombre.length() > 20) {
                throw new IllegalArgumentException("El nombre debe tener entre 3 y 20 caracteres.");
            }
            if (rutaAvatar == null || rutaAvatar.trim().isEmpty()) {
                throw new IllegalArgumentException("El avatar no puede estar vacío.");
            }
            if (!(rutaAvatar.endsWith(".jpg") || rutaAvatar.endsWith(".png") || rutaAvatar.endsWith(".jpeg"))) {
                throw new IllegalArgumentException("El avatar debe ser una URL válida de imagen (jpg, png, gif).");
            }
            if (colores == null || colores.isEmpty()) {
                throw new IllegalArgumentException("Debe proporcionarse al menos un color.");
            }
            if (colores.size() > 5) {
                throw new IllegalArgumentException("No se pueden proporcionar más de 5 colores.");
            }
        } catch (IllegalArgumentException e) {
            setEstado(false);
            notificarError(e.getMessage());
        }
    }

}
