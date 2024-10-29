package com.example.GestorTienda.aplication.service;

import com.example.GestorTienda.domain.model.Recarga;
import com.example.GestorTienda.domain.repository.IRecarga;
import com.example.GestorTienda.domain.service.IRecargaService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RecargaServiceImplementation implements IRecargaService {

    private final IRecarga recRep;

    //Inyectando dependencias
    public RecargaServiceImplementation(IRecarga recRep) {
        this.recRep = recRep;
    }

    @Override
    public Recarga crearRecarga(Recarga recarga) {
        return recRep.save(recarga);

    }

    @Override
    public Recarga obtenerRecarga(int id) {
        return recRep.findById(id).orElse(null);
    }

    @Override
    public List<Recarga> obtenerRecargas() {
        return recRep.findAll();
    }

    @Override
    public Recarga actualizarRecarga(int id, Recarga recarga) {
        Recarga updateRecarga = recRep.findById(id).get();
        if(recRep.existsById(id)){
            updateRecarga.setFecha(recarga.getFecha());
            updateRecarga.setMonto(recarga.getMonto());
            updateRecarga.setPersona(recarga.getPersona());
            return  recRep.save(updateRecarga);
        }

        return null;
    }

    @Override
    public void eliminarRecarga(int id) {
    recRep.deleteById(id);
    }
}
