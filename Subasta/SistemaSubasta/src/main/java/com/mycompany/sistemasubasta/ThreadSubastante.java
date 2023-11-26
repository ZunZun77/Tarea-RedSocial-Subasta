package com.mycompany.sistemasubasta;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
public class ThreadSubastante extends Thread{
    Socket cliente;
    InterfazSubastante interfaz;

    public ThreadSubastante(Socket cliente, InterfazSubastante interfaz){
        this.cliente = cliente;
        this.interfaz = interfaz;
    }

    DataInputStream entrada;
    DataOutputStream salida;

    public void run () {
        while (true) {
            try {
                entrada = new DataInputStream(cliente.getInputStream());
                String Autor = entrada.readUTF();
                interfaz.Autores.add(Autor);
                String precio = entrada.readUTF();
                interfaz.AgregarPublicacion(Autor + " " + precio);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
}
