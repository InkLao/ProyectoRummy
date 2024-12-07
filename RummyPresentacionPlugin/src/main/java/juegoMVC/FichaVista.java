/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegoMVC;

import javax.swing.Icon;

/**
 *
 * @author marlon
 */
class FichaVista {
    
    private int codigo;
    private int numero;
    private String color;
    private boolean esComodin;
    private Icon imagen;

    public FichaVista() {
    }

    public FichaVista(int codigo, int numero, String color, boolean esComodin, Icon imagen) {
        this.codigo = codigo;
        this.numero = numero;
        this.color = color;
        this.esComodin = esComodin;
        this.imagen = imagen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEsComodin() {
        return esComodin;
    }

    public void setEsComodin(boolean esComodin) {
        this.esComodin = esComodin;
    }

    public Icon getImagen() {
        return imagen;
    }

    public void setImagen(Icon imagen) {
        this.imagen = imagen;
    }
    
}
