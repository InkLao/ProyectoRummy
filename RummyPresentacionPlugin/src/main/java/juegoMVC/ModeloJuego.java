/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoMVC;

import java.util.List;
import javax.swing.Icon;

/**
 *
 * @author carli
 */
public class ModeloJuego implements IModeloJuego {
    
    private ObservadorJuego observadorJuego;
    private List<FichaVista> mano;
    private List<GrupoVista> tablero;
    private List<Integer> seleccion;

    public ModeloJuego() {
    }

    public ModeloJuego(ObservadorJuego observadorJuego, List<FichaVista> mano, List<GrupoVista> tablero, List<Integer> seleccion) {
        this.observadorJuego = observadorJuego;
        this.mano = mano;
        this.tablero = tablero;
        this.seleccion = seleccion;
    }

    void jalarFicha() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void colocarGrupo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void terminarTurno() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void seleccionarFicha(int codigo) {
        
        if (this.seleccion.contains(codigo)) {
            this.seleccion.remove(codigo);
        } else {
            this.seleccion.add(codigo);
        }
        
    }

    @Override
    public void notificar() {
        this.observadorJuego.actualizar(this);
    }

    @Override
    public List<FichaVista> getMano() {
        return this.mano;
    }

    @Override
    public List<GrupoVista> getTablero() {
        return this.tablero;
    }
    
}
