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
    String celebritylog = "Seguidor Id: ";

    //Constructores
    Seguidor(){
        id = 100;
    }   
    
    Seguidor(int id, Celebridad celeb){
        this.id = id;
        this.celeb = celeb;
        celebritylog = celebritylog + id + "\n";
    }
    //Métodos = comportamiento de los objetos o lo que pueden hacer

    String getLog(){
        return celebritylog;
    }
    @Override
    public void UpdateSeguidores(int seguidores) {
        //System.out.println("record" + celeb.getNombre() + " ha llegado a " + celeb.seguidores + " seguidores!");
        celebritylog = celebritylog + celeb.getNombre() + " ha llegado a " + seguidores + " seguidores!\n";
    }

    public void UpdatePublicacion(Publicacion publicacion) {
        //System.out.println("Se ha registrado una nueva publicacion");
        celebritylog = celebritylog + celeb.getNombre() + " ha publicado: " + publicacion.texto + "\n";
    }

    public void UpdateLikes(Publicacion publicacion, int likes) {
        //System.out.println("Se ha registrado un registro de likes" + publicacion.likes);
        celebritylog = celebritylog + celeb.getNombre() + " ha llegado a " + likes + " likes! en su publicacion: " + publicacion.texto + "\n";
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

