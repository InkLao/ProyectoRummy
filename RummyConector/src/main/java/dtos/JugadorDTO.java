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
    private List<Color> tiradaInicial;

    public JugadorDTO(String nombre, String avatar, List<Color> tiradaInicial) {
        this.nombre = nombre;
        this.avatar = avatar;
        this.tiradaInicial = tiradaInicial;
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

    public List<Color> getTiradaInicial() {
        return tiradaInicial;
    }

    public void setTiradaInicial(List<Color> tiradaInicial) {
        this.tiradaInicial = tiradaInicial;
    }
 
}
