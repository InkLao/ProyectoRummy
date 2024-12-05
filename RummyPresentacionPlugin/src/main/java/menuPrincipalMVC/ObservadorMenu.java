/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package menuPrincipalMVC;

/**
 *
 * @author carli
 */
public interface ObservadorMenu {

    public void mostrarMensaje(String mensaje);

    public void actualizar(IModeloMenu modeloMenu);

    public void mostrarError(String mensaje);
}
