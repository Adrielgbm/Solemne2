package com;

import java.util.Stack;

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

    
}