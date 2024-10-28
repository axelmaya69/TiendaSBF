package com.example.GestorTienda.domain.service;

import com.example.GestorTienda.domain.model.Producto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IProductoService {

    Producto crearProducto(Producto producto);
    Producto obtenerProducto(int id);
    List<Producto> obtenerProductos();
    Producto actualizarProducto(int id, Producto producto);
    void eliminarProducto(int id);

}
