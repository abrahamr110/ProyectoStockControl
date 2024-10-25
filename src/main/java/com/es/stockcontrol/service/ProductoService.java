package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.repository.ProductoRepository;

import java.util.List;

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

    public static RespuestaHTTP<Producto> bajaProducto(String id) {
        if (id.isBlank()) {
            return new RespuestaHTTP<Producto>(400, "Id cant be blank", null);
        }

        Producto producto = ProductoRepository.getProducto(id);

        if (producto == null) {
            return new RespuestaHTTP<Producto>(404, "The id is not correct", null);
        }

        ProductoRepository.bajaProducto(id);

        return new RespuestaHTTP<Producto>(200, "OK", producto);
    }

    public static RespuestaHTTP<Producto> modificarNombreProducto(String id, String nuevoNombre) {
        if (id.isBlank() || nuevoNombre.isBlank()) {
            return new RespuestaHTTP<Producto>(400, "Id/name cant be blank", null);
        }

        Producto producto = ProductoRepository.getProducto(id);

        if (producto == null) {
            return new RespuestaHTTP<Producto>(404, "The id is not correct", null);
        }

        ProductoRepository.modificarProducto(id, nuevoNombre);

        producto.setNombre(nuevoNombre);

        return new RespuestaHTTP<Producto>(200, "OK", producto);
    }

    public static RespuestaHTTP<Producto> modificarStockProducto(String id, String nuevoStock) {
        if (id.isBlank() || nuevoStock.isBlank()) {
            return new RespuestaHTTP<Producto>(400, "Id/name cant be blank", null);
        }

        try {
            int stock = Integer.parseInt(nuevoStock);

            Producto producto = ProductoRepository.getProducto(id);

            if (producto == null) {
                return new RespuestaHTTP<Producto>(404, "The id is not correct", null);
            }

            ProductoRepository.modificarStock(id, stock);
            producto.setStock(stock);

            return new RespuestaHTTP<Producto>(200, "OK", producto);
        } catch (NumberFormatException e) {
            return new RespuestaHTTP<Producto>(400, "Stock need to be a number", null);
        }
    }

    public static RespuestaHTTP<Producto> getProducto(String id) {
        if (id.isBlank()) {
            return new RespuestaHTTP<Producto>(400, "Id cant be blank", null);
        }

        Producto producto = ProductoRepository.getProducto(id);

        if (producto != null) {
            return new RespuestaHTTP<Producto>(200, "OK", producto);
        } else {
            return new RespuestaHTTP<Producto>(404, "Product not found", null);
        }
    }

    public static List<Producto> getProductosConStock() {
        List<Producto> productos = ProductoRepository.getProductosConStock();

        return productos;
    }

    public static List<Producto> getProductosSinStock() {
        List<Producto> productos = ProductoRepository.getProductosSinStock();

        return productos;
    }
}
