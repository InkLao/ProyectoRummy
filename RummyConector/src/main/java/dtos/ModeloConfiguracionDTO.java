/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author carli
 */
public class ModeloConfiguracionDTO implements Serializable {
    private int rangoFichas;
    private int numeroComodines;

    public ModeloConfiguracionDTO() {
    }

    public ModeloConfiguracionDTO(int rangoFichas, int numeroComodines) {
        this.rangoFichas = rangoFichas;
        this.numeroComodines = numeroComodines;
    }

    public int getRangoFichas() {
        return rangoFichas;
    }

    public void setRangoFichas(int rangoFichas) {
        this.rangoFichas = rangoFichas;
    }

    public int getNumeroComodines() {
        return numeroComodines;
    }

    public void setNumeroComodines(int numeroComodines) {
        this.numeroComodines = numeroComodines;
    }
    
    
}
