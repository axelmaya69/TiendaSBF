package com.example.GestorTienda.domain.repository;


import com.example.GestorTienda.domain.model.Prestamo;
import com.example.GestorTienda.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IPrestamo extends JpaRepository<Prestamo,Integer> {
    List<Prestamo> findByPersonaContaining(String persona);
}
