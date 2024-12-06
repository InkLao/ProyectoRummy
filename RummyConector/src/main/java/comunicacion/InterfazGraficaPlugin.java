/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package comunicacion;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author carli
 */
public interface InterfazGraficaPlugin {

    public void crearJugador(String nombre, String avatar, List<Color> colores) throws IllegalArgumentException, IOException;
    public void encontrarPartida() throws IllegalArgumentException, IOException;
    public void enviarConfiguracionPartida(int rango, int numeroComodines) throws IllegalArgumentException, IOException;


}
