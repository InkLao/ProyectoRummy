/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rummy;

import registrarJugadorMVC.ControladorRegistro;
import registrarJugadorMVC.ModeloRegistro;
import registrarJugadorMVC.VistaRegistro;

/**
 *
 * @author user
 */
public class Rummy {

    public static void main(String[] args) {
        ModeloRegistro modeloRegistro= new ModeloRegistro();
        ControladorRegistro controladorRegistro= new ControladorRegistro(modeloRegistro);
        VistaRegistro vistaRegistro= new VistaRegistro(controladorRegistro);
        modeloRegistro.setObservadorRegistro(vistaRegistro);
        controladorRegistro.mostrarPantalla();
    }
}
