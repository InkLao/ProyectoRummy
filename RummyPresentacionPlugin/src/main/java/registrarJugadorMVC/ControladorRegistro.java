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
    
    public ControladorRegistro(ModeloRegistro modeloRegistro,ControlMenuPrincipal controlMenuPrincipal) {
        this.modeloRegistro = modeloRegistro;
        this.controlMenuPrincipal= controlMenuPrincipal;
        
    }
    
    public void seleccionarAvatar(String avatar) {
        modeloRegistro.setVisible(true);
        modeloRegistro.setRutaAvatar(avatar);
        modeloRegistro.setRutaAvatarAgrandado();
        modeloRegistro.notificar();
    }
    
    public void seleccionarColorFicha(int index, Color color) {
        modeloRegistro.cambiarColor(index, color);
        modeloRegistro.notificar();
    }
    
    public void seleccionarNombre(String nombre) {
        modeloRegistro.setNombre(nombre);
    }
    
    public void mostrarPantalla() {
        modeloRegistro.setVisible(true);
        modeloRegistro.notificar();
    }
    
    public void registrarJugador() {
        modeloRegistro.setEstado(true);
        modeloRegistro.validarDatos();
        if (modeloRegistro.isEstado()) {
            modeloRegistro.registrarJugador();
        }
    }
    
    public void mostrarMenu(){
        modeloRegistro.setVisible(false);
        modeloRegistro.notificar();
        controlMenuPrincipal.mostrarPantalla();
    }
    
}
