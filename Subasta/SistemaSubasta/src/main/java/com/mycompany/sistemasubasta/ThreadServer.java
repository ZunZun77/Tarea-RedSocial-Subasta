package com.mycompany.sistemasubasta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;

public class ThreadServer extends Thread {
    Socket cliente;
    Server server;
    boolean running = true;

    DataInputStream entrada;
    DataOutputStream salida;


    public ThreadServer(Socket cliente, Server server) {
        this.cliente = cliente;
        this.server = server;
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
        while(running){
        try {
            entrada = new DataInputStream(cliente.getInputStream());
            salida = new DataOutputStream(cliente.getOutputStream());
            int opcion = entrada.readInt();
            if (opcion == 3) {
                String Autor = entrada.readUTF();
                String Precio = entrada.readUTF();
                OutputStream adminOutputStream = server.Subastas.get(0).Admin.getOutputStream();
                salida = new DataOutputStream(adminOutputStream);
                salida.writeUTF(Autor);
                salida.writeUTF(Precio);
            } else if (opcion == 4) {
                String buscar = entrada.readUTF();
                for (Ofertante oferente : server.Subastas.get(0).ofertas) {
                      oferente.update(buscar);;  
                    
                }
            } else if (opcion == 5){
                String ganador = entrada.readUTF();
                for (Ofertante oferente : server.Subastas.get(0).ofertas) {
                    if (oferente.nick.equals(ganador)){
                        salida.writeUTF("Ganaste la subasta");
                    } else {
                        salida.writeUTF("No ganaste la subasta");
                    }
                }

            } else {
                    salida.writeUTF("No ganaste la subasta");
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
