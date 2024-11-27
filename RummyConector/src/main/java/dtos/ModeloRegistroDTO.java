/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author carli
 */
public class ModeloRegistroDTO implements Serializable {
    private String avatar;
    private List<Color> colores;
    private String nombre;

    public ModeloRegistroDTO() {
    }

    public ModeloRegistroDTO(String avatar, List<Color> colores, String nombre) {
        this.avatar = avatar;
        this.colores = colores;
        this.nombre = nombre;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Color> getColores() {
        return colores;
    }

    public void setColores(List<Color> colores) {
        this.colores = colores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
