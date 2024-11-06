package com.example.GestorTienda.domain.service;

import com.example.GestorTienda.domain.model.Prestamo;
import com.example.GestorTienda.domain.model.Producto;

import java.util.List;


public interface IPrestamoService {

    Prestamo crearPrestamo(Prestamo prestamo);
    Prestamo obtenerPrestamo(int id);
    List<Prestamo> obtenerPorNombre(String nombre);
    List<Prestamo> obtenerPrestamos();
    Prestamo actualizarPrestamo(int id, Prestamo prestamo);
    void eliminarPrestamo(int id);

}
