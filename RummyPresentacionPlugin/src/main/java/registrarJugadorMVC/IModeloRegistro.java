/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package registrarJugadorMVC;

import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author carli
 */
public interface IModeloRegistro {

    public boolean getVisible();

    public List<ImageIcon> getListaAvatars();

    public String getRutaAvatarAgrandado();

    public List<Color> getColores();

}
