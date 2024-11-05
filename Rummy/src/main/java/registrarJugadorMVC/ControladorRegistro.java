/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarJugadorMVC;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControladorRegistro {

    private ModeloRegistro modeloRegistro;

    public ControladorRegistro(ModeloRegistro modeloRegistro) {
        this.modeloRegistro = modeloRegistro;

    }

    public void seleccionarAvatar(String avatar) {
        modeloRegistro.setEstado(true);
        modeloRegistro.setRutaAvatar(avatar);
        modeloRegistro.setRutaAvatarAgrandado();
        modeloRegistro.notificar();
    }

    public void mostrarPantalla() {
        modeloRegistro.setEstado(true);

        modeloRegistro.notificar();
    }

}
