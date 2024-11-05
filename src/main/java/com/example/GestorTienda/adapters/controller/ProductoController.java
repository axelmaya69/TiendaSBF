package com.example.GestorTienda.adapters.controller;

import com.example.GestorTienda.domain.model.Producto;
import com.example.GestorTienda.domain.service.IProductoService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "http://localhost:3001")
public class ProductoController {

    private final IProductoService productoService;

    public ProductoController(IProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/obtener")
    public ResponseEntity<?> obtenerTodos(){
    try {
        List<Producto> productos = productoService.obtenerProductos();
        return ResponseEntity.ok(productos);
    }catch (DataAccessException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al acceder a la base de datos, intente más tarde.");
    }
    catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error, intentelo más tarde");
    }
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id){
        try{
        Producto obtenerProducto = productoService.obtenerProducto(id);
        return ResponseEntity.ok(obtenerProducto);
    } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String>  crearProduco(@RequestBody Producto producto){
    try{
        Producto guardarProducto= productoService.crearProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Creado con éxito");
    } catch (DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Producto ya existe!");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                " inténtelo más tarde");
    }
    }

    @PutMapping("actualizar/{id}")
    public  ResponseEntity<String> modificarProducto(@PathVariable int id,
                                                    @RequestBody Producto producto){
    try{
        Producto editarProducto = productoService.actualizarProducto(id,producto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Editado con éxito");
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                " inténtelo más tarde");
    }
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id){
    try{
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error" +
                " inténtelo más tarde.");
    }
    }



}
