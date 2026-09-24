package org.example.Model;

/**
 * @author Antonio Manuel Rodriguez Palenzuela
 * @version 1.0
 * @since 24/09/2026
 * Esta clase lo que llevaremos a cabo es la creación de la clase Proveedor, que nos servirá para crear los proveedores que se van a vender en la tienda.
 */
public class Proveedor {
    // Atributos de la clase Proveedor
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;

    //Constructor
    public Proveedor(int id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
