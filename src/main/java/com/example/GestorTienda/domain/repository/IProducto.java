package com.example.GestorTienda.domain.repository;


import com.example.GestorTienda.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProducto extends JpaRepository<Producto,Integer> {
}
