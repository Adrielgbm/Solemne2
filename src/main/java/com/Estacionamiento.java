package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import com.abarrientosgsilva.solemne2.Automovil;

public class Estacionamiento {
    private int maximumCapacity;
    private int parkedCars;
    private Stack cars;

    public Estacionamiento(int parkedCars) {
        cars = new Stack<>();
    }

    public int getmaximumCapacity() {
        return maximumCapacity;
    }

    public void setmaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = 8;
    }

    public Stack getCars() {
        return cars;
    }

    public void setCars(Stack cars) {
        this.cars = cars;
    }

    public int getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(int parkedCars) {
        this.parkedCars = parkedCars;
    }

    
    public Estacionamiento(int parkedCars, Stack cars) {
        this.maximumCapacity = 8;
        this.parkedCars = parkedCars;
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Estacionamiento [maximumCapacity=" + maximumCapacity + ", parkedCars=" + parkedCars + ", cars=" + cars
                + "]";
    }

    public void addCar() throws IOException {
        String patente, modelo, color, info;
        char marca = 'C';
        boolean check = false;
        String regex = "^[A-Z]{4}[0-9]{2}$|^[0-9]{4}[A-Z]{2}$";
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        do {
            System.out.print("Ingrese la patente del vehículo: ");
            patente = br.readLine();
            if(patente.matches(regex))
                check = true;
            else
                System.out.println("La patente debe tener formato AAAA99 o 9999AA.");
        } while(!check);

        check = false;
        regex = "^[CNHMF]$";

        do {
            System.out.print("\nMarcas:");
            System.out.print("C -> Chevrolet");
            System.out.print("N -> Nissan");
            System.out.print("H -> Hyundai");
            System.out.print("M -> Mercedes Benz");
            System.out.print("F -> Ford");
            System.out.print("\nIngrese la marca del vehículo: ");
            info = br.readLine();
            if(info.matches(regex)) {
                marca = info.charAt(0);
                check = true;
            }
            else
                System.out.println("Debe ingresar la letra correspondiente a una de las siguientes marcas.");
        } while(!check);

        System.out.print("Ingrese el modelo del vehículo: ");
        modelo = br.readLine();
        System.out.print("Ingrese el color del vehículo: ");
        color = br.readLine();
        cars.push(new Automovil(patente, marca, modelo, color));
        System.out.print("\nEl vehículo se ha estacionado correctamente.");
    }
}
