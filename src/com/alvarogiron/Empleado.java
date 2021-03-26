package com.alvarogiron;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado implements Serializable {
    private String nombre;
    private String dni;
    private LocalDate fechaIngreso;

    private static final long serialVersionUID = 2L;

    public Empleado(String nombre, String dni, String fechaIngreso) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = LocalDate.parse(fechaIngreso, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void suspender(){
        System.out.println(nombre + " ha sido suspendido");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | DNI: " + dni + " | Fecha de ingreso: " + fechaIngreso;
    }
}
