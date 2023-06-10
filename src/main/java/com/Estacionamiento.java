package com;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


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
        this.cars = new Stack<>();
    }
/*
 * Metodos
 * 
 */

    public void addVehicles(){
        String patente;
        String color;
        String marca;
        boolean patenteisValid=false;
        boolean flagC=false;
        boolean marcaisValid=false;

        /*
         * Patente
         * Debe tener formato "AAAA00"
         */
        System.out.println("Formato incorrecto");
        if(this.parkedCars<this.maximumCapacity){
            Scanner scanner = new Scanner(System.in);
            do{
                String regex = "[A-Z]{4}\\d{2}";
                Pattern pattern = Pattern.compile(regex);
                patente=scanner.nextLine();
                Matcher matcher = pattern.matcher(patente);
                
                if(matcher.matches()){
                    System.out.println("Patente Agregada");
                    System.out.println(patente);
                    patenteisValid=true;
                }else{
                    System.out.println("Formato incorrecto");
                }
            }while(patenteisValid);
            /*
            * Marca
            * Selección mediante menu
            */
            do{
                Scanner scanner1 = new Scanner(System.in);
                System.out.println(
                """
                    Marcas de vehiculos:
                    - C: Chevrolet
                    - N: Nissan
                    - H: Hyundai
                    - F: Ford
                    Elija la marca con la inicial Correspondiente:
                        """
               );
                marca=scanner1.nextLine();
                marca = marca.toUpperCase();
                if (marca.length() > 0) {
                char opcion = marca.charAt(0);

                switch (opcion) {
                    case '1':
                        System.out.println("Color Rojo");
                        // Realiza las operaciones correspondientes para la opción 1

                        break;
                    case '2':
                        System.out.println("Color Azul");
                        // Realiza las operaciones correspondientes para la opción 2

                        break;
                    case '3':
                        System.out.println("Color Verde");
                        // Realiza las operaciones correspondientes para la opción 3

                        break;
                    case '4':
                        System.out.println("Color Negro");
                        // Realiza las operaciones correspondientes para la opción 3

                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } 
            else {
                System.out.println("No se ingresó ninguna opción");
            }
            }while(marcaisValid);
            /*
            * Color
            * Debe tener formato "AAAA00"
            */
            do{
               color=JOptionPane.showInputDialog(null, "Ingrese el Color del vehiculo: \n"
                       + "R: Rojo \n"
                       + "A: Azul \n"
                       + "V: Verde \n"
                       + "N: Negro \n");
               color=color.toUpperCase();
               if(color.isEmpty() || (!color.equals("R") && !color.equals("A") && !color.equals("V") && !color.equals("N") )){
                   JOptionPane.showMessageDialog(null, "El Color no es correcto Intente nuevamente");
               }else{
                   flagC=true;
               }
            }while(!flagC);

            Nodo vehiculo=new Nodo(patente,marca, color);
            this.estacionamientos.push(vehiculo);
            this.espaciosActuales++;
        }
        else{
        JOptionPane.showMessageDialog(null, "No se puede ingresar otro Vehiculo, estacionamiento completo");
        
        }
    }
    @Override
    public String toString() {
        return "Estacionamiento [maximumCapacity=" + maximumCapacity + ", parkedCars=" + parkedCars + ", cars=" + cars
                + "]";
    }


}
