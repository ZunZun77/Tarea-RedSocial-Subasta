package com.mycompany.sistemasubasta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadServer {
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendInt(int data){
        try {
            salida.writeInt(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    void static run() {
        try {
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            int opcion = entrada.readInt();
            if (opcion == 1){
                username = entrada.readUTF();
                String nombrePartida = entrada.readUTF();
                int cantidadJugadores = entrada.readInt();
                server.crearPartida(username, nombrePartida, cantidadJugadores, cliente, this);
            }
            else if (opcion == 2){
                String nombrePartida = entrada.readUTF();
                String host = entrada.readUTF();
                server.iniciarPartida(nombrePartida, host);
            }
        } catch (Exception e) {

    }
    }