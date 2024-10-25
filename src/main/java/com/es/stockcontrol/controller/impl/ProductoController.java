package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProductoControllerAPI;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProductoService;

import java.util.ArrayList;
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
        RespuestaHTTP<Producto> productoUpdated = ProductoService.modificarStockProducto(id, nuevoStock);

        return productoUpdated;
    }

    @Override
    public RespuestaHTTP<Producto> getProducto(String id) {
        RespuestaHTTP<Producto> productoRespuestaHTTP = ProductoService.getProducto(id);

        return productoRespuestaHTTP;
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosConStock() {
        List<Producto> productos = ProductoService.getProductosConStock();

        if (productos == null || productos.isEmpty()) {
            return new RespuestaHTTP<List<Producto>>(204, "No content", new ArrayList<Producto>());
        }

        return new RespuestaHTTP<List<Producto>>(200, "OK", productos);
    }

    @Override
    public RespuestaHTTP<List<Producto>> getProductosSinStock() {
        List<Producto> productos = ProductoService.getProductosSinStock();

        if (productos == null || productos.isEmpty()) {
            return new RespuestaHTTP<List<Producto>>(204, "No content", new ArrayList<Producto>());
        }

        return new RespuestaHTTP<List<Producto>>(200, "OK", productos);    }
}
