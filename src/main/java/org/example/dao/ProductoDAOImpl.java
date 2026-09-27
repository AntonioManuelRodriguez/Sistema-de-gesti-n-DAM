package org.example.dao;

import org.example.model.Producto;

import java.util.List;

public class ProductoDAOImpl implements ProductoDAO {

    @Override
    public void guardar(Producto producto) {
        // TODO: SQL de INSERT
    }

    @Override
    public Producto buscarPorid(int id) {
        return null;
    }

    @Override
    public Producto buscarPorId(int id) {
        // TODO: SQL de SELECT
        return null;
    }

    @Override
    public List<Producto> listar() {
        // TODO: SQL de SELECT
        return null;
    }

    @Override
    public void actualizar(Producto producto) {
        // TODO: SQL de UPDATE
    }

    @Override
    public boolean eliminar(int id) {
        // TODO: SQL de DELETE
        return false;
    }
}