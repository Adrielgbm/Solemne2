package com.abarrientosgsilva.solemne2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Estacionamiento {
    private int maximumCapacity;
    private int parkedCars;
    private Stack<Automovil> cars;

    public Estacionamiento() {
        cars = new Stack<>();
        parkedCars = 0;
        maximumCapacity = 8;
    }

    public int getmaximumCapacity() {
        return maximumCapacity;
    }

    public void setmaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
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
    
    @Override
    public String toString() {
        return "Estacionamiento [maximumCapacity=" + maximumCapacity + ", parkedCars=" + parkedCars + ", cars=" + cars
                + "]";
    }

    public void addCar() throws IOException {
        if(parkedCars < maximumCapacity) {
            String patente, modelo, color = "Rojo", info;
            int num;
            char marca = 'C';
            boolean check = false;
            String regex = "^[CNHMF]$";
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            patente = validatePatent();

            do {
                System.out.println("\nMarcas:");
                System.out.println("C -> Chevrolet");
                System.out.println("N -> Nissan");
                System.out.println("H -> Hyundai");
                System.out.println("M -> Mercedes Benz");
                System.out.println("F -> Ford");
                System.out.print("\nIngrese la marca del vehículo: ");
                info = br.readLine().toUpperCase();
                if(info.matches(regex)) {
                    marca = info.charAt(0);
                    check = true;
                }
                else
                    System.out.println("Debe ingresar la letra correspondiente a una de las siguientes marcas.");
            } while(!check);

            System.out.print("Ingrese el modelo del vehículo: ");
            modelo = br.readLine();

            check = false;

            do {
                System.out.println("\nColores:");
                System.out.println("1. Rojo");
                System.out.println("2. Azul");
                System.out.println("3. Verde");
                System.out.println("4. Negro");
                System.out.println("\nIngrese el color del vehículo: ");
                num = Integer.parseInt(br.readLine());
                switch (num) {
                        case 1:
                            color = "Rojo";
                            check = true;
                            break;

                        case 2:
                            color = "Azul";
                            check = true;
                            break;

                        case 3:
                            color = "Verde";
                            check = true;
                            break;

                        case 4:
                            color = "Negro";
                            check = true;
                            break;

                        default:
                            System.out.println("Debe ingresar el número correspondiente a uno de los siguientes colores.");
                            break;
                    }
            } while(!check);
            cars.push(new Automovil(patente, marca, modelo, color));
            parkedCars++;
            System.out.println("\nEl vehículo se ha estacionado correctamente.");
        } else
            System.out.println("\nNo hay espacio en el estacionamiento.");
    }

    public String validatePatent() throws IOException {
        String patente;
        Boolean check = false;
        String regex = "^[A-Z]{4}[0-9]{2}$|^[0-9]{4}[A-Z]{2}$";
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        do {
            System.out.print("Ingrese la patente del vehículo: ");
            patente = br.readLine().toUpperCase();
            if(patente.matches(regex))
                check = true;
            else
                System.out.println("La patente debe tener formato AAAA99 o 9999AA.");
        } while(!check);
        return patente;
    }

    public void addCar(Automovil auto) {
        if(parkedCars < maximumCapacity) {
            cars.push(auto);
            parkedCars++;
        }
    }

    public Automovil takeOutCar() {
        if(parkedCars > 0) {
            parkedCars--;
            return cars.pop();
        }
        else {
            System.out.println("No hay vehículos estacionados.");
            return null;
        }
    }

    public void searchCar() throws IOException {
        if(parkedCars > 0) {
            String patent = validatePatent();
            Automovil car;
            Stack<Automovil> aux = new Stack();
            boolean found = false;

            for(int i = 0; i < parkedCars; i++) {
                car = takeOutCar();
                aux.push(car);
                if(patent.equals(car.getPatente())) {
                    System.out.println(car.showInfo());
                    found = true;
                    break;
                }
            }
            while(!aux.isEmpty()) {
                addCar(aux.pop());
            }
            
            if (!found) {
            System.out.println("No hay ningún auto con esa patente.");
            }
        } else {
        System.out.println("No hay vehículos estacionados.");
        }
    }

    public void takeOutCar(String patent) {
        if(parkedCars > 0) {
            Automovil car;
            Stack<Automovil> aux = new Stack();
            boolean found = false;

            for(int i = 0; i < parkedCars; i++) {
                car = takeOutCar();

                if(patent.equals(car.getPatente())) {
                    found = true;
                    System.out.println("Vehículo retirado con éxito.");
                    break;
                } else {
                    aux.push(car);
                }
            }
            while(!aux.isEmpty()) {
                addCar(aux.pop());
            }
            
            if(!found) {
                System.out.println("No hay ningún auto con esa patente.");
            }
        } else {
        System.out.println("No hay vehículos estacionados.");
        }
    }

    public void information() {
        if(parkedCars > 0) {
            Automovil car;
            Stack<Automovil> aux = new Stack();

            while (!cars.isEmpty()) {
                car = takeOutCar();
                System.out.println(car.showInfo());
                System.out.println("");
                aux.push(car);
            }

            while (!aux.isEmpty()) {
                addCar(aux.pop());
            }
        } else {
            System.out.println("No hay vehículos estacionados.");
        }
        
    }
}