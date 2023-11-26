package com.mycompany.sistemasubasta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;

public class ThreadServer extends Thread {
    Socket cliente;
    String username;
    Server server;
    boolean running = true;

    DataInputStream entrada;
    DataOutputStream salida;


    public ThreadServer(Socket cliente, Server server) {
        this.cliente = cliente;
        this.server = server;
    }

    public String getUsername(){
        return username;
    }

    public void sendUTF(String data){
        try {
            salida.writeUTF(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendInt(int data){
        try {
            salida.writeInt(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override

    public void run() {
        try {
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            int opcion = entrada.readInt();
            if (opcion == 3) {
                String precio = entrada.readUTF();
                OutputStream adminOutputStream = server.Subastas.get(0).Admin.getOutputStream();
                salida = new DataOutputStream(adminOutputStream);
                salida.writeUTF(precio);
            } else if (opcion == 4) {
                // Handle option 4
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}