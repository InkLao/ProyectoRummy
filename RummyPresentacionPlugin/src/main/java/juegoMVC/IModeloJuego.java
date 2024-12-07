/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoMVC;

import java.util.List;

/**
 *
 * @author marlon
 */
public interface IModeloJuego {
    void notificar();
    
    List<FichaVista> getMano();
    
    List<GrupoVista> getTablero();
}
