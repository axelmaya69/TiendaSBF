package com.example.GestorTienda.aplication.service;

import com.example.GestorTienda.domain.model.Producto;
import com.example.GestorTienda.domain.repository.IProducto;
import com.example.GestorTienda.domain.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
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
    public List<Producto> obtenerPorNombre(String nombre) {
    return prodRep.findByNombreContaining(nombre);
    }


    @Override
    public List<Producto> obtenerProductos() {
        return prodRep.findAll();
    }

    @Override
    public Producto actualizarProducto(@PathVariable int id, Producto producto) {
        Producto updateProducto = prodRep.findById(id).get();
        if(prodRep.existsById(id)){
            updateProducto.setNombre(producto.getNombre());
            updateProducto.setPrecio(producto.getPrecio());
            return prodRep.save(updateProducto);
    }
        return null;
    }

    @Override
    public void eliminarProducto(int id) {
    prodRep.deleteById(id);
    }
}
