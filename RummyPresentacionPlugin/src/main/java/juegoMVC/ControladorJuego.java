/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoMVC;

/**
 *
 * @author carli
 */
public class ControladorJuego {
    
    private ModeloJuego modeloJuego;
    
    public ControladorJuego() {
        
    }
    
    public ControladorJuego(ModeloJuego modeloJuego) {
        this.modeloJuego = modeloJuego;
    }

    public void setModeloJuego(ModeloJuego modeloJuego) {
        this.modeloJuego = modeloJuego;
    }
    
    public void jalarFicha() {
        this.modeloJuego.jalarFicha();
    }
    
    public void seleccionarFicha(int codigo) {
        this.modeloJuego.seleccionarFicha(codigo);
    }
    
    public void colocarGrupo() {
        this.modeloJuego.colocarGrupo();
    }
    
    public void terminarTurno() {
        this.modeloJuego.terminarTurno();
    }
    
}
