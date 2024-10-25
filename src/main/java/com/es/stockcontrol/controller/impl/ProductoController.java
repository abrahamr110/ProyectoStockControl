package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProductoControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;

import java.util.List;

public class ProductoController implements ProductoControllerAPI {

    @Override
    public RespuestaHTTP<Producto> altaProducto(String categoriaProducto, String nombreProducto, String precioSinIva, String descripcionProducto, String nombreProveedor, String direccionProveedor) {
        RespuestaHTTP<Producto> productoRespuestaHTTP = ProductoService.altaProducto(categoriaProducto, nombreProducto, precioSinIva, descripcionProducto, nombreProveedor, direccionProveedor);

        return productoRespuestaHTTP;
    }

    @Override
    public RespuestaHTTP<Producto> bajaProducto(String id) {
        RespuestaHTTP<Producto> productoRespuestaHTTP = ProductoService.bajaProducto(id);

        return productoRespuestaHTTP;
    }

    @Override
    public RespuestaHTTP<Producto> modificarNombreProducto(String id, String nuevoNombre) {
        RespuestaHTTP<Producto> productoUpdated = ProductoService.modificarNombreProducto(id, nuevoNombre);

        return productoUpdated;
    }

    @Override
    public RespuestaHTTP<Producto> modificarStockProducto(String id, String nuevoStock) {
        return null;
    }

    @Override
    public RespuestaHTTP<Producto> getProducto(String id) {
        return null;
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosConStock() {
        return null;
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosSinStock() {
        return null;
    }
}
