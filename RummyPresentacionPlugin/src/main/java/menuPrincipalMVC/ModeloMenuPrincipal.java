/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuPrincipalMVC;

import comunicacion.FachadaCore;

/**
 *
 * @author carli
 */
public class ModeloMenuPrincipal implements IModeloMenu{
    private ObservadorMenu observadorMenu;    
    private boolean visible;
    private FachadaCore core;

    public ModeloMenuPrincipal(FachadaCore core) {
        this.core = core;
    }


    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void notificar(){
        observadorMenu.actualizar(this);
    }
    
    public void encontrarPartida(){
        
    }

    @Override
    public boolean getVisible() {
        return visible;
    }
    
}
