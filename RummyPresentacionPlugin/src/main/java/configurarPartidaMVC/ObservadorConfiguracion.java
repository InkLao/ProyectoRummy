/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package configurarPartidaMVC;

/**
 *
 * @author carli
 */
public interface ObservadorConfiguracion {
    public void actualizar(IModeloConfigurarPartida modeloConfigurarPartida);

    public void mostrarMensaje(String mensaje);

    public void mostrarError(String mensaje);
}
