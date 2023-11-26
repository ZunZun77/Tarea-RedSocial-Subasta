package com.mycompany.sistemasubasta;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface IOobservable {
    void registerObserver();
    void removeObserver();
    void notifyObservers();
}

// Observer interface
interface Observer {
    void update();
    void unsubscribe();
}

// Concrete observer class
