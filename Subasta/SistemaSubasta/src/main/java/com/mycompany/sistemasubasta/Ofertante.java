package com.mycompany.sistemasubasta;

import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
public  class Ofertante implements Observer {
    Socket socket;
    Server server;
    String nick;
    

    public Ofertante(Socket socket, Server server, String nick) {
        this.socket = socket;
        this.server = server;
        this.nick = nick;
    }

    @Override
    public void update(String precio) {
        try {
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            salida.writeUTF(precio);
        } catch (Exception e) {
            System.out.println("Error al enviar mensaje");
        }
        
        
    }
    
    @Override
    public void unsubscribe() {
        // TODO Auto-generated method stub
        
    }
}
