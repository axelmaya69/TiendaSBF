package com.example.GestorTienda.aplication.service;

import com.example.GestorTienda.domain.model.Producto;
import com.example.GestorTienda.domain.repository.IProducto;
import com.example.GestorTienda.domain.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoServiceImplementation implements IProductoService {

    private final IProducto prodRep;

    //Inyectando dependencias por constructor
    @Autowired
    public ProductoServiceImplementation(IProducto prodRep) {
        this.prodRep = prodRep;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return prodRep.save(producto);
    }

    @Override
    public Producto obtenerProducto(int id) {
        return prodRep.findById(id).orElse(null);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return prodRep.findAll();
    }

    @Override
    public Producto actualizarProducto(int id, Producto producto) {
        if(prodRep.existsById(id)){
            producto.setId(id);
            return prodRep.save(producto);
    }
        return null;
    }

    @Override
    public void eliminarProducto(int id) {
    prodRep.deleteById(id);
    }
}
