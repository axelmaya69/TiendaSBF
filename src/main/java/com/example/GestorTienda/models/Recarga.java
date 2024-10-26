package com.example.GestorTienda.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Recarga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private int monto;

    @Getter
    @Setter
    private String persona;

    @Temporal(TemporalType.DATE)
    @Getter
    @Setter
    private Date fecha;




}
