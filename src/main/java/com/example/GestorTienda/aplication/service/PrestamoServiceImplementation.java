package com.example.GestorTienda.aplication.service;

import com.example.GestorTienda.domain.model.Prestamo;
import com.example.GestorTienda.domain.repository.IPrestamo;
import com.example.GestorTienda.domain.service.IPrestamoService;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class PrestamoServiceImplementation implements IPrestamoService {

    private final IPrestamo presRep;

    public PrestamoServiceImplementation(IPrestamo presRep) {
        this.presRep = presRep;
    }


    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        return presRep.save(prestamo);
    }

    @Override
    public Prestamo obtenerPrestamo(int id) {
        return presRep.findById(id).orElse(null);
    }

    @Override
    public List<Prestamo> obtenerPrestamos() {
        return presRep.findAll();
    }

    @Override
    public Prestamo actualizarPrestamo(int id,@PathVariable Prestamo prestamo) {
        Prestamo updatePrestamo = presRep.findById(id).get();
        if (presRep.existsById(id)){
            updatePrestamo.setFecha(prestamo.getFecha());
            updatePrestamo.setDescripcion(prestamo.getDescripcion());
            updatePrestamo.setPersona(prestamo.getPersona());
            return presRep.save(updatePrestamo);
        }
        return null;
    }

    @Override
        public void eliminarPrestamo(int id) {
        presRep.deleteById(id);
        }
}
