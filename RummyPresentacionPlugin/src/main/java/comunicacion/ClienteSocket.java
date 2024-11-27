/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dtos.MensajeDTO;
import dtos.RespuestaDTO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author carli
 */
public class ClienteSocket implements Runnable {

    private Socket socketCliente;
    private ObjectInputStream in;         // Para recibir mensajes del servidor.
    private ObjectOutputStream out;       // Para enviar mensajes al servidor.
    private String servidorIP;               // IP del servidor.
    private int puerto;
    private Notificador notificador;// Puerto del servidor.

    private boolean isRunning;               // Para controlar el hilo.

    public ClienteSocket(String servidorIP, int puerto) {
        this.servidorIP = servidorIP;
        this.puerto = puerto;
        this.isRunning = true;
    }

    // Método para conectar al servidor.
    public void conectar() {
        try {
            // Conectar al servidor
            socketCliente = new Socket(servidorIP, puerto);
            System.out.println("Conectado al servidor: " + servidorIP + " en el puerto " + puerto);

            // Crear los flujos de entrada y salida para la comunicación.
            out = new ObjectOutputStream(socketCliente.getOutputStream());
            in = new ObjectInputStream(socketCliente.getInputStream());

            // Iniciar el hilo para recibir mensajes
            new Thread(this).start();  // Esto ejecuta el método run() en un hilo separado
        } catch (IOException e) {
            System.err.println("Error al conectar al servidor: " + e.getMessage());
            desconectar();
        }
    }

    // Método que implementa la interfaz Runnable
    @Override
    public void run() {
        while (isRunning) {
            try {
                RespuestaDTO mensajeRecibido = recibirMensaje();  // Recibir mensaje del servidor
                if (mensajeRecibido != null) {
                    // Procesar el mensaje recibido
                    System.out.println("Mensaje recibido del servidor: " + mensajeRecibido);
                }
            } catch (Exception e) {
                System.err.println("Error en la comunicación: " + e.getMessage());
            }
        }
    }

    // Método para enviar un mensaje al servidor.
    public void mandarMensaje(MensajeDTO mensaje) {
        try {
            out.writeObject(mensaje);  // Enviar el mensaje al servidor.
            out.flush();               // Asegurarse de que se haya enviado.
        } catch (IOException e) {
            System.err.println("Error al enviar mensaje al servidor: " + e.getMessage());
        }
    }

    // Método para recibir un mensaje del servidor.
    public RespuestaDTO recibirMensaje() {
        try {
            return (RespuestaDTO) in.readObject();  // Leer un mensaje del servidor.
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al recibir mensaje del servidor: " + e.getMessage());
            return null;
        }
    }

    // Método para cerrar la conexión con el servidor.
    public void desconectar() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socketCliente != null && !socketCliente.isClosed()) {
                socketCliente.close();
            }
            isRunning = false;  // Detener el hilo
        } catch (IOException e) {
            System.err.println("Error al cerrar la conexión con el servidor: " + e.getMessage());
        }
    }

}
