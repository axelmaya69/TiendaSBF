package com.example.GestorTienda.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String persona;

    @Getter
    @Setter
    private String descripcion;


    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private LocalDate fecha;
}
