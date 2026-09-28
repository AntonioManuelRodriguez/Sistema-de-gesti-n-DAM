package org.example.service;

import org.example.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InventarioService {

    private final List<Producto> productos = new ArrayList<>();
    private int siguienteId = 1;

    public Producto agregarProducto(String nombre, double precio, int stock) {
        Producto producto = new Producto();
        producto.setId(siguienteId++);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);

        productos.add(producto);
        return producto;
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    public Optional<Producto> buscarPorId(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public boolean actualizarProducto(Producto productoActualizado) {
        Optional<Producto> existente = buscarPorId(productoActualizado.getId());

        if (existente.isPresent()) {
            Producto producto = existente.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            return true;
        }
        return false;
    }

    public boolean eliminarProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
}