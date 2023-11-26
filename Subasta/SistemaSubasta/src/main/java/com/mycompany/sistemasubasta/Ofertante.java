package com.mycompany.sistemasubasta;

import java.net.Socket;

public  class Ofertantes implements Observer {
    Socket socket;
    Server server;
    

    public Ofertantes(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void update() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void unsubscribe() {
        // TODO Auto-generated method stub
        
    }
}
