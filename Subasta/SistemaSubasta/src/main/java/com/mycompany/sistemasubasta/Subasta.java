package com.mycompany.sistemasubasta;
import java.util.ArrayList;
import java.net.Socket;
import java.time.LocalDateTime;
public class Subasta implements IOobservable {
    String inicio;
    String fin;
    Producto producto;
    String Status;
    ArrayList<Ofertantes> ofertas;
    Socket Admin;


    public Subasta(String inicio, String fin, String producto, Socket Admin) {
        this.inicio = LocalDateTime.now().toString();
        this.fin = fin;
        this.producto = new Producto(producto);
        this.Admin = Admin;
        this.Status = "Activa";
        this.ofertas = new ArrayList<Ofertantes>();
    }

    public Subasta(String Nombre, Socket Admin, String fecha) {
        this.inicio = LocalDateTime.now().toString();
        this.fin = fecha;
        this.producto = new Producto(Nombre);
        this.Admin = Admin;
        this.Status = "Activa";
        this.ofertas = new ArrayList<Ofertantes>();
    }

    @Override
    public void registerObserver() {
        // TODO Auto-generated method stub
    }
    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
    }


    @Override
    public String toString() {
        return "Subasta de " + producto.nombre + " desde " + inicio + " hasta " + fin + " con estado " + Status;
    }
}
