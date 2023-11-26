package com.mycompany.sistemasubasta;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class AcceptThread extends Thread {
    Server server;
    public AcceptThread(Server server){
        this.server = server;
    }

    @Override
    public void run() {
        boolean running = true;
        while(running){
            System.out.println("AcceptThread started");
            try {
                Socket cliente = server.serverSocket.accept();
                System.out.println("Cliente aceptado");
                if (cliente != null){
                    DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                    DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                    int opcion = entrada.readInt();
                    if (opcion == 1){
                        String nombre = entrada.readUTF();
                        String fecha = entrada.readUTF();
                        Subasta subasta = new Subasta(nombre, cliente, fecha);
                        server.Subastas.add(subasta);
                    } 
                    else if (opcion == 2){
                        String nick = entrada.readUTF();
                        System.out.println("Nick recibido");
                        OfertanteSeleccionarSubasta interfaz = new OfertanteSeleccionarSubasta(nick, cliente);
                        for (Subasta subasta : server.Subastas){
                            interfaz.AgregarPublicacion(subasta);
                        }
                        interfaz.setVisible(true);
                        int index = interfaz.index;
                        while (index == -1){
                            index = interfaz.index;
                        }
                        System.out.println("Index recibido");
                        Subasta subasta = server.Subastas.get(index);
                        subasta.ofertas.add(new Ofertante(cliente, server));
                        String Fecha = subasta.fin;
                        String Precio = subasta.producto.precioActual;
                        salida.writeUTF(Fecha);
                        salida.writeUTF(Precio);
                        System.out.println("Datos enviados");
                        interfaz.dispose();


                    }
                
            }else{
                System.out.println("Cliente nulo");}}
             catch (Exception e) {
                System.out.println("Error al aceptar cliente");
            }
        }
    }
}

