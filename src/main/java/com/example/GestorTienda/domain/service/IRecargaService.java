package com.example.GestorTienda.domain.service;

import com.example.GestorTienda.domain.model.Producto;
import com.example.GestorTienda.domain.model.Recarga;

import java.util.List;

public interface IRecargaService {

    Recarga crearRecarga(Recarga recarga);
    Recarga obtenerRecarga(int id);
    List<Recarga> obtenerRecargas();
    List<Recarga> obtenerPorNombre(String nombre);
    Recarga actualizarRecarga(int id,Recarga recarga);
    void eliminarRecarga(int id);

}
