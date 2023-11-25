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
    void UpdateLikes(Publicacion publicacion);
    void UpdatePublicacion(Publicacion publicacion);
    void UpdateSeguidores();
    void unsubscribe();
}

// Concrete observer class

