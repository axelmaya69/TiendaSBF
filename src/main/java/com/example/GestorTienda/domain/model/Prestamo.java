package com.example.GestorTienda.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Date fecha;
}
