/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package juegoMVC;

/**
 *
 * @author carli
 */
public interface ObservadorJuego {
    public void actualizar(IModeloJuego modeloConfigurarPartida);

    public void mostrarMensaje(String mensaje);

    public void mostrarError(String mensaje);
}
