package com.alvarogiron;

import java.io.Serializable;

public class Perro implements Serializable {
    private String nombre;
    private byte raza;
    private byte edad;
    private String direccion;

    private static final long serialVersionUID = 3L;

    public Perro(String nombre, byte raza, byte edad, String direccion) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.direccion = direccion;
    }

    public void bark(){
        System.out.println(nombre + " ladró.");
    }

    @Override
    public String toString() {
        return nombre + " | Raza: " + raza + " | Edad: " + edad + " | Dirección: " + direccion;
    }
}
