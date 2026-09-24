package org.example.model;

/**
 *
 * @author Antonio Manuel Rodriguez Palenzuela
 * @version 1.0
 * @since 24/09/2026
 * Esta clase lo que llevaremos a cabo es la creación de la clase Categoria, que nos servirá para crear las categorias que se van a vender en la tienda.
 *
 */
public class Categoria {
    // Atributos de la clase Categoria
    private int id;
    private String nombre;

    //Constructor
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
