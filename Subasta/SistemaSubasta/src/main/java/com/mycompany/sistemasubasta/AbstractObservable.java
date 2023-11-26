package com.mycompany.sistemasubasta;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface IOobservable {
    void registerObserver();
    void notifyObservers();
}

// Observer interface
interface Observer {
    void update(String precio);
    void unsubscribe();
}

// Concrete observer class
