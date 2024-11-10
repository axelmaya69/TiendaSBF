package com.example.GestorTienda.adapters.controller;


import com.example.GestorTienda.domain.model.Prestamo;
import com.example.GestorTienda.domain.service.IPrestamoService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiado")
@CrossOrigin(origins = "http://localhost:3000")
public class PrestamoController {

    private final IPrestamoService prestamoService;

    public PrestamoController(IPrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping("/obtener")
    public ResponseEntity <?> obtenerTodos() {
        try {
            List<Prestamo> prestamos = prestamoService.obtenerPrestamos();
            return ResponseEntity.ok(prestamos);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al acceder a la base de datos, intente más tarde.");
        }

        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, intentelo más tarde");
        }
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<?> obtenerPorNombre(@RequestParam String persona) {
        try {
            List<Prestamo> prestamos = prestamoService.obtenerPorNombre(persona);
            return ResponseEntity.ok(prestamos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }





    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int id){
    try {
        Prestamo obtenerPrestamo = prestamoService.obtenerPrestamo(id);
        return ResponseEntity.ok(obtenerPrestamo);
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error, inténtelo más tarde.");
    }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> guardarPrestamo(@RequestBody Prestamo prestamo){
    try {
        Prestamo nuevoPrestamo = prestamoService.crearPrestamo(prestamo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Creado con éxito");
    } catch (DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Préstamo ya existente!");
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, " +
                "intentélo más tarde");
    }
    }

    @PutMapping("/actualizar/{id}")
        public  ResponseEntity<String> actualizarPrestamo(@PathVariable int id,
                                                        @RequestBody Prestamo prestamo){
        try {
            Prestamo actualizarPrestamo = prestamoService.actualizarPrestamo(id, prestamo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Editado con éxito");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error," +
                    "inténtelo más tarde.");
        }
        }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarPrestamo(@PathVariable int id){
    try {
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error," +
                "inténtelo más tarde.");
    }
    }

}
