package com.example.GestorTienda.domain.repository;


import com.example.GestorTienda.domain.model.Producto;
import com.example.GestorTienda.domain.model.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRecarga extends JpaRepository<Recarga,Integer> {
    List<Recarga> findByNombreContaining(String nombre);
}
