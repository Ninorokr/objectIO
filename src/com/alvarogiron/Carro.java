package com.alvarogiron;

import java.io.Serializable;

public class Carro implements Serializable {
    private String marca;
    private String modelo;
    private double precio;
    private boolean electrico;

    private static final long serialVersionUID = 1L;

    public Carro(String marca, String modelo, double precio, boolean electrico) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.electrico = electrico;
    }

    public void encender(){
        System.out.println(modelo + " encendió el motor");
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " | precio: " + precio;
    }
}
