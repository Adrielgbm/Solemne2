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

    Estacionamiento est = new Estacionamiento();
    System.out.print("""
                  **************************************************
                  *            M E N U: Estacionamiento            *
                  *                S O L E M N E 2                 *
                  *    Author:  Adriel Barrientos - Gabriel Silva  *
                  **************************************************
                  *                                                *
                  *   1. Agregar Vehiculo                          *
                  *   2. Sacar Vehiculo (Patente)                  *
                  *   3. Buscar vehiculo (Patente)                 *
                  *   4. Informacion Estacionamiento               *
                  *   5. Salir                                     *
                  *                                                *
                  **************************************************
                  Ingrese una opcion:""");
    
    do{
        try{      
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion) {
                case 1:
                    est.addCar();
                    break;
                    
                case 2:
                    String patent = est.validatePatent();
                    est.takeOutCar(patent);
                    break;
                    
                case 3:
                    est.searchCar();
                    break;

                case 4:
                    est.information();
                    break;

                default:
                    System.out.println("Opción inválida.");
                    break;
            
            }
        }
        catch(Exception ex) {
            System.out.println("Error (" + ex + ")");
            opcion = 0;
        }
        
    }while(opcion != 5);
    }
}
