/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package registrarJugadorMVC;

import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author carli
 */
public interface IModeloRegistro {

    public boolean getEstado();
    public List<ImageIcon> getListaAvatars();
    public String getRutaAvatarAgrandado();
}
