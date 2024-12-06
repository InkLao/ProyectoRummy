/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurarPartidaMVC;

import menuPrincipalMVC.ControlMenuPrincipal;

/**
 *
 * @author carli
 */
public class ControladorConfigurarPartida {

    private ModeloConfigurarPartida modeloConfigurarPartida;
    private ControlMenuPrincipal controlMenuPrincipal;

    public ControladorConfigurarPartida(ModeloConfigurarPartida modeloConfigurarPartida, ControlMenuPrincipal controlMenuPrincipal) {
        this.modeloConfigurarPartida = modeloConfigurarPartida;
        this.controlMenuPrincipal = controlMenuPrincipal;
    }

    public void mostrarPantalla() {
        modeloConfigurarPartida.setVisible(true);
        modeloConfigurarPartida.notificar();
    }

    public void seleccionarNumeroComodines(int numeroComodines) {
        modeloConfigurarPartida.setNumeroComodines(numeroComodines);
        modeloConfigurarPartida.notificar();
    }

    public void seleccionarRango(int rango) {
        modeloConfigurarPartida.setRangoFichas(rango);
        modeloConfigurarPartida.notificar();

    }

    public void asignarConfiguracionPartida() {
        modeloConfigurarPartida.setEstado(true);
        modeloConfigurarPartida.validarDatos();
        if (modeloConfigurarPartida.isEstado()) {
            modeloConfigurarPartida.asignarConfiguracionPartida();
            this.mostrarMenu();

        }
    }

    public void mostrarMenu() {
        modeloConfigurarPartida.setVisible(false);
        modeloConfigurarPartida.notificar();
        controlMenuPrincipal.mostrarPantalla();
    }

}
