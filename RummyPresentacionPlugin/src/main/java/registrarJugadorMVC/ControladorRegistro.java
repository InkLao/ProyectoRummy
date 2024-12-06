/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarJugadorMVC;

import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import menuPrincipalMVC.ControlMenuPrincipal;

/**
 *
 * @author user
 */
public class ControladorRegistro {

    private ModeloRegistro modeloRegistro;
    private ControlMenuPrincipal controlMenuPrincipal;

    public ControladorRegistro(ModeloRegistro modeloRegistro, ControlMenuPrincipal controlMenuPrincipal) {
        this.modeloRegistro = modeloRegistro;
        this.controlMenuPrincipal = controlMenuPrincipal;

    }

    public void seleccionarAvatar(String avatar) {
        modeloRegistro.setVisible(true);
        modeloRegistro.setRutaAvatar(avatar);
        modeloRegistro.setRutaAvatarAgrandado();
    }

    public void seleccionarColorFicha(int index, Color color) {
        modeloRegistro.cambiarColor(index, color);
    }

    public void seleccionarNombre(String nombre) {
        modeloRegistro.setNombre(nombre);
    }

    public void mostrarPantalla() {
        modeloRegistro.setVisible(true);
    }

    public void registrarJugador() {
        modeloRegistro.setEstado(true);
        modeloRegistro.validarDatos();

        if (!modeloRegistro.isEstado()) {
            return; // Exit early if validation fails
        }

        modeloRegistro.registrarJugador();

        if (modeloRegistro.isEstado()) {
            this.mostrarMenu();
        }
    }

    public void mostrarMenu() {
        modeloRegistro.setVisible(false);
        controlMenuPrincipal.mostrarPantalla();
    }

}
