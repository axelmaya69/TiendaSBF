package com.example.GestorTienda.interfaces;

import com.example.GestorTienda.domain.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto,Integer> {
}
