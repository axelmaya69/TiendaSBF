package com.example.GestorTienda.interfaces;

import com.example.GestorTienda.domain.models.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecarga extends JpaRepository<Recarga,Integer> {
}
