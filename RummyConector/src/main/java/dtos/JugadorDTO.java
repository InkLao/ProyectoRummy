/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.awt.Color;
import java.util.List;

/**
 *
 * @author carli
 */
public class JugadorDTO {
    private String nombre;
    private String avatar;
    private List<Color> colores;

    public JugadorDTO(String nombre, String avatar, List<Color> colores) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.colores = colores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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
 
}
