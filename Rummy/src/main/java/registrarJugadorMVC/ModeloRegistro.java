/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarJugadorMVC;


import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author user
 */


public class ModeloRegistro {
    
    private String nombre;
    private String avatar;
    private String colorFicha;

    public ModeloRegistro(String nombre, String avatar, String colorFicha) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.colorFicha = colorFicha;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getColorFicha() {
        return colorFicha;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setColorFicha(String colorFicha) {
        this.colorFicha = colorFicha;
    }
}



   




