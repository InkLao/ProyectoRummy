/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.rummy;

import comunicacion.ClienteSocket;
import comunicacion.FachadaCore;
import comunicacion.Notificador;
import configurarPartidaMVC.ControladorConfigurarPartida;
import configurarPartidaMVC.ModeloConfigurarPartida;
import configurarPartidaMVC.VistaConfigurarPartida;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import menuPrincipalMVC.ControlMenuPrincipal;
import menuPrincipalMVC.ModeloMenuPrincipal;
import registrarJugadorMVC.ControladorRegistro;
import registrarJugadorMVC.ModeloRegistro;
import registrarJugadorMVC.VistaRegistro;

/**
 *
 * @author user
 */
public class Rummy {

    public static void main(String[] args) {

        ClienteSocket clienteSocket = new ClienteSocket("127.0.0.1", 5000);
        FachadaCore core = new FachadaCore(clienteSocket);
        ModeloRegistro modeloRegistro = new ModeloRegistro(core);
        ModeloConfigurarPartida modeloConfigurarPartida= new ModeloConfigurarPartida(core);
        ModeloMenuPrincipal modeloMenuPrincipa= new ModeloMenuPrincipal(core);
        Notificador notificador = new Notificador(modeloRegistro,modeloConfigurarPartida );
        ControlMenuPrincipal menuPrincipal= new ControlMenuPrincipal(modeloMenuPrincipa);
        ControladorConfigurarPartida controladorConfigurarPartida= new ControladorConfigurarPartida(modeloConfigurarPartida, menuPrincipal);
        ControladorRegistro controladorRegistro = new ControladorRegistro(modeloRegistro, menuPrincipal);
        VistaRegistro vistaRegistro = new VistaRegistro(controladorRegistro);
        VistaConfigurarPartida vistaConfigurarPartida= new VistaConfigurarPartida(controladorConfigurarPartida);

        modeloRegistro.setObservadorRegistro(vistaRegistro);
        clienteSocket.setNotificador(notificador);
        controladorRegistro.mostrarPantalla();
        clienteSocket.conectar();
    }
}
