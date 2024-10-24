package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.repository.ProductoRepository;

public class ProductoService {
    public static RespuestaHTTP<Producto> altaProducto(String categoriaProducto, String nombreProducto, String precioSinIva, String descripcionProducto, String nombreProveedor, String direccionProveedor) {
        if (!categoriaProducto.isBlank() && !nombreProducto.isBlank() && !precioSinIva.isBlank() && !descripcionProducto.isBlank() && !nombreProveedor.isBlank() && !direccionProveedor.isBlank()) {
            try {
                float precioSinIvafl = Float.parseFloat(precioSinIva);
                Proveedor proveedor = new Proveedor(nombreProveedor, direccionProveedor);
                Producto producto = new Producto(nombreProducto, categoriaProducto, descripcionProducto, precioSinIvafl, (float) (precioSinIvafl * 1.21), proveedor);
                Producto productoCreated = ProductoRepository.altaProducto(proveedor, producto);

                return new RespuestaHTTP<Producto>(200, "OK", productoCreated);
            } catch (NumberFormatException e) {
                return new RespuestaHTTP<Producto>(400, "Price need to be a number", null);
            }
        } else {
            return new RespuestaHTTP<Producto>(400, "One or more fields are empty", null);
        }
    }
}
