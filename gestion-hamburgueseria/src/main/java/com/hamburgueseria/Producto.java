/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.hamburgueseria;

public class Producto {

    private int id;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    // Constructor para añadir productos.
    public Producto(String nombre, String descripcion,
                    double precio, int stock) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor para productos existentes.
    public Producto(int id, String nombre, String descripcion, double precio, int stock) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }
    
    //Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
    
    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //toString
    @Override
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre
                + " | Descripción: " + descripcion
                + " | Precio: " + precio + " €"
                + " | Stock: " + stock;
    }
}



