package com.example.GestorTienda.domain.repository;


import com.example.GestorTienda.domain.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPrestamo extends JpaRepository<Prestamo,Integer> {
}
