/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import dtos.MensajeDTO;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author carli
 */
public class Server {

    private int port;
    private ServerSocket serverSocket;
    private boolean isRunning;
    private ExecutorService threadPool; // Para manejar clientes con hilos.
    private Protocolo protocolo;
    private AtomicInteger clientCounter; // Contador para IDs únicos

    public Server(int port, Protocolo protocolo) {
        this.port = port;
        this.protocolo=protocolo;
        this.isRunning = false;
        this.threadPool = Executors.newCachedThreadPool();
        this.clientCounter = new AtomicInteger(1000); // Inicia en 1

    }

    public void empezar() {
        try {
            serverSocket = new ServerSocket(port);
            isRunning = true;
            System.out.println("Servidor iniciado en el puerto " + port);
            aceptarClientes();
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    private void aceptarClientes() {
        while (isRunning) {
            try {
                System.out.println("Esperando conexiones de clientes...");
                Socket clientSocket = serverSocket.accept(); // Espera una conexión.
                int clientId = clientCounter.getAndIncrement();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                // Crea un manejador de cliente y lo ejecuta en un hilo.
                ManejadorCliente clienteManejador = new ManejadorCliente(clientSocket, clientId, protocolo);
                threadPool.execute(clienteManejador);
                MensajeDTO mensaje = new MensajeDTO("SUSCRIBIR_CLIENTE");
                System.out.println(mensaje.getAccion());
                protocolo.ejecutarAccion(clienteManejador, mensaje);

            } catch (IOException e) {
                if (isRunning) {
                    System.err.println("Error al aceptar cliente: " + e.getMessage());
                } else {
                    System.out.println("Servidor cerrado.");
                }
            }
        }
    }

    public void cerrarServidor() {
        try {
            isRunning = false;
            if (serverSocket != null) {
                serverSocket.close();
            }
            threadPool.shutdown(); // Detiene todos los hilos activos.
            System.out.println("Servidor cerrado.");
        } catch (IOException e) {
            System.err.println("Error al cerrar el servidor: " + e.getMessage());
        }
    }
}
