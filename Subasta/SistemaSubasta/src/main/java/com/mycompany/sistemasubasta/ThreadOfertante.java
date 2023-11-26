package com.mycompany.sistemasubasta;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ThreadOfertante extends Thread {
    Socket cliente;
    String username;
    boolean running = true;
    InterfazOfertante interfaz;

    DataInputStream entrada;
    DataOutputStream salida;

    public ThreadOfertante(Socket cliente, InterfazOfertante interfaz) {
        this.cliente = cliente;
        this.interfaz = interfaz;
        try {
            salida = new DataOutputStream(cliente.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("ThreadOfertante started");
                entrada = new DataInputStream(cliente.getInputStream());
                String precio = entrada.readUTF();
                if (precio.equals("Ganaste la subasta")){
                    interfaz.Precio.setText(precio);
                    running = false;
                    interfaz.dispose();
                    break;
                }
                interfaz.Precio.setText("Precio: " + precio);       
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}