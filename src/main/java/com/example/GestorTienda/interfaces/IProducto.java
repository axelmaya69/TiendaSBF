package com.example.GestorTienda.interfaces;

import com.example.GestorTienda.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto,Integer> {
}
