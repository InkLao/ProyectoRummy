/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuPrincipalMVC;

/**
 *
 * @author carli
 */
public class ControlMenuPrincipal {
    ModeloMenuPrincipal modeloMenuPrincipal;
    
    

    public ControlMenuPrincipal(ModeloMenuPrincipal modeloMenuPrincipal) {
        this.modeloMenuPrincipal = modeloMenuPrincipal;
    }
    
    
    public void mostrarPantalla() {
        modeloMenuPrincipal.setVisible(true);
        modeloMenuPrincipal.notificar();
    }
    
}
