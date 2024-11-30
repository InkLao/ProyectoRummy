/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author eduar
 */
public class ManejadorColores {
    private TipoFicha tipo;
    private String color;

    public ManejadorColores() {
    }

    public ManejadorColores(TipoFicha tipo, String color) {
        this.tipo = tipo;
        this.color = color;
    }

    public TipoFicha getTipo() {
        return tipo;
    }

    public void setTipo(TipoFicha tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void obtenerColor(TipoFicha tipo){
        System.out.println("Te daré el color de la ficha");
    }
}
