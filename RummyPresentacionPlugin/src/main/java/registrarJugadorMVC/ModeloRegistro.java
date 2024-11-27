/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarJugadorMVC;

import dtos.ModeloRegistroDTO;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class ModeloRegistro implements IModeloRegistro, ObservadorModeloRegistro {

    private ObservadorRegistro observadorRegistro;
    private String nombre;
    private String rutaAvatar;
    private String rutaAvatarAgrandado;
    private List<ImageIcon> listaAvatars;
    private List<Color> colores;
    private boolean estado;

    public ModeloRegistro() {
        this.listaAvatars = new ArrayList<>();
        this.colores = new ArrayList<>();
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
    }

    public void cambiarColor(int index, Color color) {
        colores.set(index, color);
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
    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void notificar() {
        observadorRegistro.actualizar((IModeloRegistro) this);
    }

    @Override
    public void actualizarModeloRegistro(ModeloRegistroDTO modeloRegistroDTO) {
        this.colores=modeloRegistroDTO.getColores();
        this.nombre= modeloRegistroDTO.getNombre();
        this.rutaAvatar= modeloRegistroDTO.getAvatar();
        this.setRutaAvatarAgrandado();
        this.notificar();
    }

}
