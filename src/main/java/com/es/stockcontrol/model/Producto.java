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

    public Producto () {}

    public Producto(String nombre, String categoria, String descripcion, float precio_sin_iva, float precio_con_iva, Date fecha_alta, Proveedor proveedor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio_sin_iva = precio_sin_iva;
        this.precio_con_iva = precio_con_iva;
        this.fecha_alta = fecha_alta;
        this.proveedor = proveedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio_sin_iva() {
        return precio_sin_iva;
    }

    public void setPrecio_sin_iva(float precio_sin_iva) {
        this.precio_sin_iva = precio_sin_iva;
    }

    public float getPrecio_con_iva() {
        return precio_con_iva;
    }

    public void setPrecio_con_iva(float precio_con_iva) {
        this.precio_con_iva = precio_con_iva;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}

