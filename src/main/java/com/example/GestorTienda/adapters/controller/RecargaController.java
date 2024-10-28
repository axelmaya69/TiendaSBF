package com.example.GestorTienda.adapters.controller;

import com.example.GestorTienda.domain.model.Recarga;
import com.example.GestorTienda.domain.service.IRecargaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recargas")
public class RecargaController {

    private final IRecargaService recargaService;


    public RecargaController(IRecargaService recargaService) {
        this.recargaService = recargaService;
    }

    @GetMapping("/obtener")
    public ResponseEntity<List<Recarga>> obtenerRecargas(){
        List<Recarga> recargas = recargaService.obtenerRecargas();
        return ResponseEntity.ok(recargas);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<Recarga> obtenerRecarga(@PathVariable int id){
        Recarga getRecarga = recargaService.obtenerRecarga(id);
        return  ResponseEntity.ok(getRecarga);
    }

    @PostMapping("/crear")
    public ResponseEntity<Recarga> crearRecarga(@RequestBody Recarga recarga){
        Recarga saveRecarga = recargaService.crearRecarga(recarga);
        return  ResponseEntity.ok(saveRecarga);
    }

    @PutMapping("/actualizar/{id}")
    public  ResponseEntity<Recarga> actualizarRecarga(@PathVariable int id,
                                                      @RequestBody Recarga recarga){
        Recarga updateRecarga = recargaService.actualizarRecarga(id, recarga);
        return  ResponseEntity.ok(updateRecarga);
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<Void> eliminarRecarga(@PathVariable int id){
        recargaService.eliminarRecarga(id);
        return  ResponseEntity.noContent().build();
    }


}
