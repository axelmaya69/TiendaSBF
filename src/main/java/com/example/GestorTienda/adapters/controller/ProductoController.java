package com.example.GestorTienda.adapters.controller;

import com.example.GestorTienda.domain.model.Producto;
import com.example.GestorTienda.domain.service.IProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/obtener")
    public ResponseEntity<List<Producto>> obtenerTodos(){
        List<Producto> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable int id){
        Producto obtenerProducto = productoService.obtenerProducto(id);
        return ResponseEntity.ok(obtenerProducto);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto>  crearProduco(@RequestBody Producto producto){
        Producto guardarProducto= productoService.crearProducto(producto);
        return ResponseEntity.ok(guardarProducto) ;
    }

    @PutMapping("actualizar/{id}")
    public  ResponseEntity<Producto> modificarProducto(@PathVariable int id,
                                                    @RequestBody Producto producto){
        Producto editarProducto = productoService.actualizarProducto(id,producto);
        return ResponseEntity.ok(editarProducto);
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable int id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();

    }



}
