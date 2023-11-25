/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoRedSocial;

//import sockets
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Victor
 */
public class Seguidor implements Observer {
     //Atributos
    int id;
    Celebridad celeb;
    String celebritylog = "";
    InterfazSeguidor interfaz = null;
    //Constructores
    Seguidor(){
        id = 100;
    }   
    
    Seguidor(int id, Celebridad celeb){
        this.id = id;
        this.celeb = celeb;
    }
    //Métodos = comportamiento de los objetos o lo que pueden hacer

    void InterfazSeguidor(InterfazSeguidor interfaz) {
        SocketClient socket = null;
        try {
            socket = new SocketClient(new Socket("127.0.0.1", 1050));
        } catch (Exception e) {
            System.out.println("Error al crear la interfaz");
            return ;
        }
        interfaz = new InterfazSeguidor(this, socket);
        interfaz.setVisible(true);
    }

    @Override
    public void UpdateSeguidores() {
        System.out.println("record" + celeb.getNombre() + " ha llegado a " + celeb.seguidores + " seguidores!");
        celebritylog = celeb.getNombre() + " ha llegado a " + celeb.seguidores + " seguidores!";
    }

    public void UpdatePublicacion(Publicacion publicacion) {
        System.out.println("Se ha registrado una nueva publicacion");
        celebritylog = celeb.getNombre() + " ha publicado: " + publicacion.texto;
    }

    public void UpdateLikes(Publicacion publicacion) {
        System.out.println("Se ha registrado un registro de likes" + publicacion.likes);
        celebritylog = celeb.getNombre() + " ha llegado a " + publicacion.likes + " likes! en su publicacion: " + publicacion.texto + "\n";
    }

    @Override
    public void unsubscribe() {
        System.out.println("Se ha eliminado un observador");
    }

    void imprimirAmigo(){
        System.out.println(this.id + " " + this.celeb.getNombre() + " " + this.celeb.seguidores);
        
    }
    public static void main(String args[]) {
        Seguidor seguidor = new Seguidor();
        seguidor.imprimirAmigo();
    }
    
}

