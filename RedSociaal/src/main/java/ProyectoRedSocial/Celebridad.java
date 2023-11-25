package ProyectoRedSocial;


//array include
import java.util.ArrayList;

//socket include
import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;

class Celebridad implements IOobservable {
    private ArrayList<Observer> observers = new ArrayList<>();
    int seguidores;
    ArrayList<Publicacion> publicaciones;
    private String nombre;
    SocketClient socket;

    Celebridad() {
        nombre = "Pending";
        seguidores = 0;
        publicaciones = new ArrayList<>();

    }

    Celebridad( String nombre) {
        this.nombre = nombre;
        this.seguidores = 0;
        this.publicaciones = new ArrayList<>();
        try {
            socket = new SocketClient(new Socket("127.0.0.1", 1050));
        } catch (IOException e) {
            throw new RuntimeException("No se pudo abrir el puerto 1050");
        }
        new ThreadCelebridad(this).start();
        
    }
    public Seguidor CrearSeguidorSocket() {
        Seguidor seguidor = new Seguidor(9999999, this);
        observers.add(seguidor);
        return seguidor;
    }

    public void AgregarSeguidores(int seguidores) {
        for (int i = 0; i < seguidores; i++) {
            this.seguidores++;
            Seguidor seguidor = new Seguidor(i, this);
            observers.add(seguidor);   
        }
        
    }

    public void AgregarLikes(int likes, int index) {
        
        if (index > publicaciones.size()) {
            System.out.println("No existe la publicacion");
            return;
        }
        Publicacion publicacion = publicaciones.get(index);
        publicacion.likes += likes;
        
    }

    public void AgregarDislikes(int dislikes, int index) {
        if (index > publicaciones.size()) {
            System.out.println("No existe la publicacion");
            return;
        }
        Publicacion publicacion = publicaciones.get(index);
        publicacion.dislikes += dislikes;
    }



    public Publicacion publicar(String texto) {
        Publicacion publicacion = new Publicacion(texto);
        publicaciones.add(publicacion);
        notifyObservers(1,publicacion);
        return publicacion;
    }


    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Se ha registrado un nuevo observador");
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Se ha eliminado un observador");
    }

    @Override
    public void notifyObservers(int determinador, Publicacion publicacion) {
        //1 = publicacion 2 = likes 3 = seguidores
        if (determinador == 1)  {
            for (int i = 0; i < observers.size(); i++) {
                observers.get(i).UpdatePublicacion(publicacion);
            }
        } else if (determinador == 2) {
            for (int i = 0; i < observers.size(); i++) {
                observers.get(i).UpdateLikes(publicacion);
            }
        } else if (determinador == 3) {
            for (int i = 0; i < observers.size(); i++) {
                observers.get(i).UpdateSeguidores();
            }
        }
    }


    public String getNombre() {
        return nombre;
    }


}