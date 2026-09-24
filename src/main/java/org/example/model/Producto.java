package org.example.model;

/**
 * @author Antonio Manuel Rodriguez Palenzuela
 * @version 1.0
 * @since 24/09/2025
 * Esta clase lo que llevaremos a cabo es la creación de la clase Producto, que nos servirá para crear los productos que se van a vender en la tienda.
 */

public class Producto {
    // Atributos de la clase Productos
    private int id;
    private String nombre;
    private double precio;
    private int Stock;
    private String Categoria;

    //Constructor
    public Producto(int id, String nombre, double precio, int stock, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        Stock = stock;
        Categoria = categoria;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }
}
