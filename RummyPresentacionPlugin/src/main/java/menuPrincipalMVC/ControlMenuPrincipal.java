/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuPrincipalMVC;

import configurarPartidaMVC.ControladorConfigurarPartida;

/**
 *
 * @author carli
 */
public class ControlMenuPrincipal {
    ModeloMenuPrincipal modeloMenuPrincipal;
    ControladorConfigurarPartida configurarPartida;
    
    

    public ControlMenuPrincipal(ModeloMenuPrincipal modeloMenuPrincipal) {
        this.modeloMenuPrincipal = modeloMenuPrincipal;
    }
    
    
    public void mostrarPantalla() {
        modeloMenuPrincipal.setVisible(true);
        modeloMenuPrincipal.notificar();
    }
    
    public void mostraConfiguracionPartida(){
        modeloMenuPrincipal.setVisible(false);
        modeloMenuPrincipal.notificar();
        configurarPartida.mostrarPantalla();
    }

    public void setConfigurarPartida(ControladorConfigurarPartida configurarPartida) {
        this.configurarPartida = configurarPartida;
    }
    
    
}
