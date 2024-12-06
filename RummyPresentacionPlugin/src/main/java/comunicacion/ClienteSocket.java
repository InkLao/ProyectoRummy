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
        try {
            while (isRunning) {
                Object mensaje = in.readObject(); // Leer mensajes del cliente.
                if (mensaje instanceof RespuestaDTO) {
                    recibirMensaje((RespuestaDTO) mensaje);
                } else {
                    System.out.println("Mensaje desconocido recibido del servidor.");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en la comunicación con el servidor: " + e.getMessage());
        } catch (Exception ex) {
            System.err.println("Error en la comunicacióna: " + ex.getMessage());
        }
    }

    // Método para enviar un mensaje al servidor.
    public void mandarMensaje(MensajeDTO mensaje) {
        try {
            out.writeObject(mensaje);  // Enviar el mensaje al servidor.
            out.flush();               // Asegurarse de que se haya enviado.
        } catch (IOException  | NullPointerException e) {
            System.err.println("Error al enviar mensaje al servidor: " + e.getMessage());
            RespuestaDTO respuestaError = new RespuestaDTO("ENVIO_MENSAJE", false, "Error en la comunicación: no se pudo conectar con el servidor",mensaje.getDto());
            notificador.setRespuestaDTO(respuestaError);
        }
    }

    // Método para recibir un mensaje del servidor.
    public void recibirMensaje(RespuestaDTO respuesta) {
        notificador.setRespuestaDTO(respuesta);
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

    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    }

}
