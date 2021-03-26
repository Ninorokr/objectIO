package com.alvarogiron;

import java.io.*;
import java.nio.Buffer;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static List<Carro> carros = new LinkedList<>();
    static List<Perro> perros = new LinkedList<>();
    static List<Empleado> empleados = new LinkedList<>();

    static String[] archivos = {"carros", "perros", "empleados"};


    public static void main(String[] args){
        System.out.println("Ingresando a main()");
        System.out.println(carros.toString());
        System.out.println(perros.toString());
        System.out.println(empleados.toString());

        guardar();
    }

    static {
        System.out.println("Ingresando a bloque de inicialización estático");
        for (int i = 0; i < archivos.length; i++) {
            try (ObjectInputStream ous = new ObjectInputStream(new BufferedInputStream(new FileInputStream(archivos[i]+".dat")))) {
                boolean eof = false;
                System.out.println("Intenando leer objetos desde " + archivos[i] + ".dat");
                while (!eof) {
                    try {
                        switch(i){
                             case 0: carros.add((Carro) ous.readObject()); break;
                             case 1: perros.add((Perro) ous.readObject()); break;
                             case 2: empleados.add((Empleado) ous.readObject()); break;
                        }
                    } catch (EOFException eofe) {
                        eof = true;
                        System.out.println("Se leyeron los objetos de " + archivos[i] + ".dat");
                    }
                }
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("No se encontró archivo " + archivos[i] + ".dat o no coincide con clase serializada");
                e.getMessage();
                System.out.println("Poblando colecciones con datos hard-coded");
                if(carros.isEmpty()){
                    carros.add(new Carro("Toyota", "Yaris", 60000, false));
                    carros.add(new Carro("Toyota", "Camry", 90000, false));
                    carros.add(new Carro("Toyota", "Corolla", 75000, false));
                    carros.add(new Carro("Porsche", "Cayman", 120000, false));
                    carros.add(new Carro("Porsche", "Boxter", 150000, true));
                    carros.add(new Carro("Porsche", "Carrera", 180000, false));
                    carros.add(new Carro("Renault", "Alaskan", 180000, false));
                    carros.add(new Carro("Renault", "Captur", 220000, true));
                    carros.add(new Carro("Renault", "Clio", 240000, false));
                }

                if(perros.isEmpty()){
                    perros.add(new Perro("Coco", (byte)0, (byte)5, "Jr. Bolivia 100"));
                    perros.add(new Perro("Thor", (byte)1, (byte)3, "Jr. Perú 200"));
                    perros.add(new Perro("Max", (byte)2, (byte)6, "Jr. Chile 300"));
                    perros.add(new Perro("Rocky", (byte)3, (byte)8, "Jr. Brasil 400"));
                    perros.add(new Perro("Toby", (byte)4, (byte)11, "Jr. Nicaragua 500"));
                    perros.add(new Perro("Simba", (byte)5, (byte)2, "Jr. Venezuela 600"));
                    perros.add(new Perro("Leo", (byte)6, (byte)16, "Jr. Colombia 700"));
                    perros.add(new Perro("Lucas", (byte)7, (byte)1, "Jr. Uruguay 800"));
                }

                if(empleados.isEmpty()){
                    empleados.add(new Empleado("Alvaro", "46530119", "20/08/2016"));
                    empleados.add(new Empleado("Augusto", "11111111", "14/01/1999"));
                    empleados.add(new Empleado("Alfonso", "22222222", "10/07/2016"));
                    empleados.add(new Empleado("Victor", "33333333", "30/01/1995"));
                    empleados.add(new Empleado("Katherine", "44444444", "19/06/2018"));
                    empleados.add(new Empleado("Jorge", "55555555", "22/03/2017"));
                }
            }
        }
    }

    public static void guardar(){
        System.out.println("Ingresando a guardar()");
        for(int i = 0; i < archivos.length; i++){
            try(ObjectOutputStream ous = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(archivos[i]+".dat")))){
                switch(i){
                    case 0:
                        System.out.println("Guardando objetos tipo Carro");
                        for(Carro carro : carros){
                            ous.writeObject(carro);
                        } break;
                    case 1:
                        System.out.println("Guardando objetos tipo Perro");
                        for(Perro perro : perros){
                            ous.writeObject(perro);
                        } break;
                    case 2:
                        System.out.println("Guardando objetos tipo Empleado");
                        for(Empleado empleado : empleados){
                            ous.writeObject(empleado);
                        } break;
                }
            } catch (IOException ioe){
                System.out.println("No se pudo guardar por conflicto con el sistema de archivos");
                ioe.getMessage();
            }
        }
    }
}
