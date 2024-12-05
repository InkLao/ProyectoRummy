/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rummy;

import comunicacion.ClienteSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
//            ClienteSocket clienteSocket=new ClienteSocket( "127.0.0.1", 5000);
//            clienteSocket.conectar();
    }
}
