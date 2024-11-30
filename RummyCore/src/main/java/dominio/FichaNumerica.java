/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author eduar
 */
public class FichaNumerica extends Ficha {
    
    private int numero;
    private TipoFicha tipo;
    private String color;
    private ManejadorColores manejador;

    public FichaNumerica() {
    }

    public FichaNumerica(int numero, TipoFicha tipo, String color, ManejadorColores manejador) {
        this.numero = numero;
        this.tipo = tipo;
        this.color = color;
        this.manejador = manejador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public ManejadorColores getManejador() {
        return manejador;
    }

    public void setManejador(ManejadorColores manejador) {
        this.manejador = manejador;
    }
    
    public void getColorPersonalizado(){
        
    }
}
