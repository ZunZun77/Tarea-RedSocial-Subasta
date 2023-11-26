package com.mycompany.sistemasubasta;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;
public class Server {

    ArrayList<Subasta> Subastas;
    ServerSocket serverSocket;
    ThreadServer threadServer;
    AcceptThread acceptThread;
    Socket InterfazSubastante;

    public Server() {
        Subastas = new ArrayList<Subasta>();
        try {
            serverSocket = new ServerSocket(1050);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo abrir el puerto 1050");
        }
        acceptThread = new AcceptThread(this, InterfazSubastante);
        acceptThread.start();
        
    }

    public void broadcastUTF(String data, int index) {
        Subasta subasta = Subastas.get(index);
        for (Ofertante cliente : subasta.ofertas) {
            try {
                DataOutputStream salida = new DataOutputStream(cliente.socket.getOutputStream());
                salida.writeUTF(data);
            } catch (Exception e) {
                System.out.println("Error al enviar mensaje");
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
