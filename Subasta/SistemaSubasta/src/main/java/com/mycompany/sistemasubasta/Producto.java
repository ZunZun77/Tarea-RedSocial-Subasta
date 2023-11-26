package com.mycompany.sistemasubasta;

public class Producto {
    String nombre;
    String precioInicial;
    String precioActual;

   Producto (String nombre, String precioInicial){
       this.nombre = nombre;
       this.precioInicial = precioInicial;
       this.precioActual = precioInicial;
   } 

    Producto (String nombre){
         this.nombre = nombre;
         this.precioInicial = "0";
         this.precioActual = "0";
    }

    public String getNombre(){
         return nombre;
    }

    public String getPrecioInicial(){
        return precioInicial;
    }

    public String getPrecioActual(){
        return precioActual;
    }
}
