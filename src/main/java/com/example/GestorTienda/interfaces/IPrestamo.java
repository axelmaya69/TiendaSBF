package com.example.GestorTienda.interfaces;

import com.example.GestorTienda.domain.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrestamo extends JpaRepository<Prestamo,Integer> {
}
