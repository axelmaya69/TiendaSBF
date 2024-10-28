package com.example.GestorTienda.adapters.controller;


import com.example.GestorTienda.domain.model.Prestamo;
import com.example.GestorTienda.domain.service.IPrestamoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiado")
public class PrestamoController {

    private final IPrestamoService prestamoService;

    public PrestamoController(IPrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping("/obtener")
    public ResponseEntity <List<Prestamo>> obtenerTodos(){
        List <Prestamo> prestamos = prestamoService.obtenerPrestamos();
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Prestamo> obtenerPorId(@PathVariable int id){
    Prestamo obtenerPrestamo = prestamoService.obtenerPrestamo(id);
    return ResponseEntity.ok(obtenerPrestamo);
    }

    @PostMapping("/crear")
    public ResponseEntity<Prestamo> guardarPrestamo(@RequestBody Prestamo prestamo){
        Prestamo nuevoPrestamo =prestamoService.crearPrestamo(prestamo);
        return  ResponseEntity.ok(nuevoPrestamo);
    }

    @PutMapping("/actualizar/{id}")
    public  ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable int id,
                                                        @RequestBody Prestamo prestamo){
        Prestamo actualizarPrestamo = prestamoService.actualizarPrestamo(id,prestamo);
        return ResponseEntity.ok(actualizarPrestamo);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable int id){
         prestamoService.eliminarPrestamo(id);
        return ResponseEntity.noContent().build();
    }





}
