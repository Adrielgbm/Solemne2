package com.abarrientosgsilva.solemne2;

public class Automovil {
    private String patente;
    private char marca;
    private String modelo;
    private String color;

    public Automovil() {
    }

    public Automovil(String color, char marca, String modelo, String patente) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public char getMarca() {
        return marca;
    }

    public void setMarca(char marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Automovil [patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + "]";
    }

    public String showInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPatente: ").append(patente);
        sb.append("\nMarca: ").append(marca);
        sb.append("\nModelo: ").append(modelo);
        sb.append("\nColor: ").append(color);
        return sb.toString();
    }
}