package com.es.stockcontrol.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Producto {
    @Id
    private String id;

    @Column(name="nombre",length = 50,nullable = false)
    private String nombre;

    @Column(name="categoria",length = 10,nullable = false)
    private String categoria;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_sin_iva",nullable = false)
    private float precio_sin_iva;

    @Column(name = "precio_con_iva",nullable = false)
    private float precio_con_iva;

    @Column(name = "fecha_alta",nullable = false)
    private Date fecha_alta;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
}

