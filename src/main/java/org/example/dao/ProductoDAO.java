package org.example.dao;

import org.example.model.Producto;

import java.util.List;

public interface ProductoDAO {

    void guardar(Producto producto);

    Producto buscarPorid(int id);

    Producto buscarPorId(int id);

    List<Producto> listar();

    void actualizar(Producto producto);

    boolean eliminar(int id);

}


