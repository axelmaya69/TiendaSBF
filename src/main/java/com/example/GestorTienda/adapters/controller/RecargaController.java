package com.example.GestorTienda.adapters.controller;

import com.example.GestorTienda.domain.model.Recarga;
import com.example.GestorTienda.domain.service.IRecargaService;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recargas")
@CrossOrigin(origins = "http://localhost:3000")
public class RecargaController {

    private final IRecargaService recargaService;


    public RecargaController(IRecargaService recargaService) {
        this.recargaService = recargaService;
    }

    @GetMapping("/obtener")
    public ResponseEntity<?> obtenerRecargas(){
    try{
        List<Recarga> recargas = recargaService.obtenerRecargas();
        return ResponseEntity.ok(recargas);
    }catch (DataAccessException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al acceder" +
                "a la base de datos, intentelo más tarde");
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error, inténtelo más tarde.");
    }
    }
    @GetMapping("/buscarPorNombre")
    public ResponseEntity<?> obtenerPorNombre(@RequestParam String persona) {
        try {
            List<Recarga> recargas = recargaService.obtenerPorNombre(persona);
            return ResponseEntity.ok(recargas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error, inténtelo más tarde.");
        }
    }





    @GetMapping("/obtener/{id}")
    public ResponseEntity<?> obtenerRecarga(@PathVariable int id){
    try{
        Recarga getRecarga = recargaService.obtenerRecarga(id);
        return  ResponseEntity.ok(getRecarga);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error, intentelo más tarde");
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearRecarga(@RequestBody Recarga recarga){
    try{
        Recarga saveRecarga = recargaService.crearRecarga(recarga);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Creado con éxito");
    } catch (DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Recarga ya existe");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error, " +
                " inténtelo más tarde");
    }
    }

    @PutMapping("/actualizar/{id}")
    public  ResponseEntity<String> actualizarRecarga(@PathVariable int id,
                                                      @RequestBody Recarga recarga){
    try{
        Recarga updateRecarga = recargaService.actualizarRecarga(id, recarga);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Editado con éxito");
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error," +
                " intentelo más tarde");
    }
    }

    @DeleteMapping("/eliminar/{id}")
    public  ResponseEntity<String> eliminarRecarga(@PathVariable int id){
    try{
        recargaService.eliminarRecarga(id);
        return  ResponseEntity.ok("Eliminado exitosamente");
    }catch (Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error," +
                " intentelo más tarde");
    }
    }

}






