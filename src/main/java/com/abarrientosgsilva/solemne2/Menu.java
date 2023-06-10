package com.abarrientosgsilva.solemne2;

import java.util.Scanner;

/*
 * Metodos:
 * Agregar automovil
 * Sacar automovil(patente)
 * Buscar automovil(patente)
 * Info estacionamiento
 */


public class Menu {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    System.out.println("""
                  **************************************************
                  *            M E N U: Estacionamiento            *
                  *                S O L E M N E 2                 *
                  *    Author:  Adriel Barrientos - Gabriel Silva  *
                  **************************************************
                  *                                                *
                  *   1. Agregar Vehiculo                          *
                  *   2. Quitar Vehiculo                           *
                  *   3. Buscar vehiculo(Patente)                  *
                  *   4. Informacion Estacionamiento               *
                  *   5. Salir                                     *
                  *                                                *
                  **************************************************
                  Ingrese una opcion:""");
    
    do{
        try{      
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1 -> System.out.println("Insertar vehiculo");
//                        e.insertarVehiculo();
                case 2 -> System.out.println("Eliminar vehiculo");
//                        e.eliminarVehiculo();
                case 3 -> System.out.println("Buscar vehiculo por patente");
//                        e.buscarVehiculoPorPatente();
                case 4 -> System.out.println("Información estacionamiento");
//                        e.mostrarVehiculos();
                case 5 -> System.out.println("error");
                default -> System.out.println("Invalid Option");
            }// fin switch  
        }
        catch(Exception ex){
            System.out.println("Invalid Option");
            opcion=0;
        }
        
    }while(opcion!= 5);
    }
}
