package ProyectoRedSocial;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface IOobservable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(int determinador, Publicacion publicacion);
}

// Observer interface
interface Observer {
    void UpdateLikes(Publicacion publicacion, int likes);
    void UpdatePublicacion(Publicacion publicacion);
    void UpdateSeguidores(int seguidores);
    void unsubscribe();
}

// Concrete observer class

