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
public class ManejadorCliente implements Runnable, IComunicacionCliente{
     private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean activo;
    private Protocolo protocolo;

    public ManejadorCliente(Socket clientSocket, Protocolo protocolo) throws IOException {
        this.clientSocket = clientSocket;
        this.protocolo= protocolo;
        this.output = new ObjectOutputStream(clientSocket.getOutputStream());
        this.input = new ObjectInputStream(clientSocket.getInputStream());
        this.activo = true;
    }

    @Override
    public void run() {
        try {
            while (activo) {
                Object mensaje = input.readObject(); // Leer mensajes del cliente.
                if (mensaje instanceof MensajeDTO) {
                    recibirMensaje((MensajeDTO) mensaje);
                } else {
                    System.out.println("Mensaje desconocido recibido del cliente.");
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            cerrarConexion();
        }
    }

    private void recibirMensaje(MensajeDTO mensaje) {
        System.out.println("Mensaje recibido: " + mensaje);
        // Aquí podrías delegar la acción a un protocolo o fachada del núcleo.
    }

     @Override
    public void mandarMensaje(RespuestaDTO respuesta) {
        try {
            output.writeObject(respuesta);
            output.flush();
        } catch (IOException e) {
            System.err.println("Error al enviar respuesta al cliente: " + e.getMessage());
        }
    }

    private void cerrarConexion() {
        try {
            activo = false;
            if (input != null) input.close();
            if (output != null) output.close();
            if (clientSocket != null && !clientSocket.isClosed()) clientSocket.close();
            MensajeDTO mensaje= new MensajeDTO("REMOVER_CLIENTE");
            protocolo.ejecutarAccion(clientSocket, mensaje);
        } catch (IOException e) {
            System.err.println("Error al cerrar la conexión del cliente: " + e.getMessage());
        }
    }

  
    
    
} 

