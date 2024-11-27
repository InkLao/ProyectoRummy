/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rummycore;

import comunicacion.Comunicacion;
import comunicacion.IComunicacionPlugin;
import comunicacion.Protocolo;
import comunicacion.Server;
import dominio.Comodin;
import dominio.FachadaGraficaCore;

/**
 *
 * @author carli
 */
public class RummyCore {

    public static void main(String[] args) {
        IComunicacionPlugin comunicacionPlugin= new Comunicacion();
        FachadaGraficaCore fachadaGraficaCore= new FachadaGraficaCore();
        Protocolo protocolo= new Protocolo(fachadaGraficaCore, comunicacionPlugin);
        Server server = new Server(5000, protocolo);
        server.empezar();
    }
}
