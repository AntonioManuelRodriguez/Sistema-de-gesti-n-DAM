package org.example.controller;

import org.example.model.Producto;
import org.example.service.InventarioService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PrincipalController {

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, Integer> colId;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    @FXML
    private TextField campoNombre;

    @FXML
    private TextField campoPrecio;

    @FXML
    private TextField campoStock;

    @FXML
    private Button botonAgregar;

    @FXML
    private Button botonEditar;

    @FXML
    private Button botonEliminar;

    @FXML
    private Label labelTotalProductos;

    @FXML
    private Label labelValorInventario;

    @FXML
    private Label labelStockBajo;

    private final InventarioService servicio = new InventarioService();
    private final ObservableList<Producto> datosTabla = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tablaProductos.setItems(datosTabla);

        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, anterior, seleccionado) -> {
            if (seleccionado != null) {
                rellenarFormulario(seleccionado);
            }
        });

        refrescarTabla();
    }

    @FXML
    public void onAgregar() {
        try {
            String nombre = campoNombre.getText().trim();
            double precio = Double.parseDouble(campoPrecio.getText().trim());
            int stock = Integer.parseInt(campoStock.getText().trim());

            if (nombre.isEmpty()) {
                mostrarAviso("El nombre no puede estar vacío.");
                return;
            }

            servicio.agregarProducto(nombre, precio, stock);
            refrescarTabla();
            limpiarFormulario();

        } catch (NumberFormatException e) {
            mostrarAviso("Precio y stock tienen que ser números.");
        }
    }

    @FXML
    public void onEditar() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAviso("Selecciona un producto de la tabla.");
            return;
        }

        try {
            seleccionado.setNombre(campoNombre.getText().trim());
            seleccionado.setPrecio(Double.parseDouble(campoPrecio.getText().trim()));
            seleccionado.setStock(Integer.parseInt(campoStock.getText().trim()));

            servicio.actualizarProducto(seleccionado);
            refrescarTabla();
            limpiarFormulario();

        } catch (NumberFormatException e) {
            mostrarAviso("Precio y stock tienen que ser números.");
        }
    }

    @FXML
    public void onEliminar() {
        Producto seleccionado = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAviso("Selecciona un producto de la tabla.");
            return;
        }

        servicio.eliminarProducto(seleccionado.getId());
        refrescarTabla();
        limpiarFormulario();
    }

    private void refrescarTabla() {
        List<Producto> productos = servicio.listarProductos();
        datosTabla.setAll(productos);
        actualizarIndicadores(productos);
    }

    private void actualizarIndicadores(List<Producto> productos) {
        int total = productos.size();
        double valorTotal = productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getStock())
                .sum();
        long stockBajo = productos.stream()
                .filter(p -> p.getStock() < 5)
                .count();

        labelTotalProductos.setText(String.valueOf(total));
        labelValorInventario.setText(String.format("%,.2f €", valorTotal));
        labelStockBajo.setText(String.valueOf(stockBajo));
    }

    private void rellenarFormulario(Producto producto) {
        campoNombre.setText(producto.getNombre());
        campoPrecio.setText(String.valueOf(producto.getPrecio()));
        campoStock.setText(String.valueOf(producto.getStock()));
    }

    private void limpiarFormulario() {
        campoNombre.clear();
        campoPrecio.clear();
        campoStock.clear();
        tablaProductos.getSelectionModel().clearSelection();
    }

    private void mostrarAviso(String mensaje) {
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}