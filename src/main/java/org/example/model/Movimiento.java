package org.example.model;

import java.time.LocalDate;

public class Movimiento {

    private int id;
    private TipoMovimiento tipo;
    private int cantidad;
    private LocalDate fecha;
    private Producto producto;

    public Movimiento() {
    }

    public Movimiento(int id, TipoMovimiento tipo, int cantidad, LocalDate fecha, Producto producto) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.producto = producto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoMovimiento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMovimiento tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - %s x%d (%s)",
                id, tipo, producto != null ? producto.getNombre() : "?", cantidad, fecha);
    }
}