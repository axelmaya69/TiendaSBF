package com.example.GestorTienda.domain.repository;


import com.example.GestorTienda.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProducto extends JpaRepository<Producto,Integer> {
    List<Producto> findByNombreContaining(String nombre);

}
