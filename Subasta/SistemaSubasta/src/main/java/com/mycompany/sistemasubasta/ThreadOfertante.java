package com.mycompany.sistemasubasta;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ThreadOfertante extends Thread {
    Socket cliente;
    String username;
    Server server;
    boolean running = true;
    InterfazOfertante interfaz;

    DataInputStream entrada;
    DataOutputStream salida;

    public ThreadOfertante(Socket cliente, Server server, InterfazOfertante interfaz) {
        this.cliente = cliente;
        this.server = server;
        this.interfaz = interfaz;
        try {
            salida = new DataOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());
                String precio = entrada.readUTF();
                interfaz.Precio.setText("Precio: " + precio);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}