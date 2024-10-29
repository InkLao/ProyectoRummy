/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrarJugadorMVC;

import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControladorRegistro {

    private VistaRegistro vista;
    private ArrayList<ModeloRegistro> jugadores;

    public ControladorRegistro(VistaRegistro vista) {
        this.vista = vista;
        this.jugadores = new ArrayList<>();

        this.vista.addRegistrarListener(new RegistrarListener());
        this.vista.addMostrarJugadoresListener(new MostrarJugadoresListener());
    }

    // Clase interna para manejar el registro
    class RegistrarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String nombre = vista.getNombre();
            String avatar = vista.getAvatar();
            String colorFicha = vista.getColorFicha();

            // Validación de campos vacíos
            if (nombre.isEmpty() || avatar.isEmpty() || colorFicha.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // No registra el jugador si hay campos vacíos
            }

            ModeloRegistro jugador = new ModeloRegistro(nombre, avatar, colorFicha);
            jugadores.add(jugador);
            JOptionPane.showMessageDialog(vista, "Jugador registrado: " + nombre);

            // Limpiar los campos de entrada
            vista.limpiarCampos();
        }
    }

    // Clase interna para mostrar jugadores
    class MostrarJugadoresListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            StringBuilder listado = new StringBuilder("Jugadores Registrados:\n");
            for (ModeloRegistro jugador : jugadores) {
                listado.append("Nombre: ").append(jugador.getNombre()).append(", Avatar: ").append(jugador.getAvatar())
                        .append(", Color Ficha: ").append(jugador.getColorFicha()).append("\n");
            }
            JOptionPane.showMessageDialog(vista, listado.toString());
        }
    }
}
