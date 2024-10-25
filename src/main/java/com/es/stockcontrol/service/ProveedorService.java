package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.repository.ProveedorRepository;

import java.util.List;

public class ProveedorService {
    public static RespuestaHTTP<Proveedor> getProveedorProducto(String idProducto) {
        if (idProducto.isBlank()) {
            return new RespuestaHTTP<Proveedor>(400, "Id cant be blank", null);
        }

        Proveedor proveedor = ProveedorRepository.getProveedorProducto(idProducto);

        if (proveedor != null) {
            return new RespuestaHTTP<Proveedor>(200, "OK", proveedor);
        } else {
            return new RespuestaHTTP<Proveedor>(404, "Product not founded or dont have proveedor", null);
        }
    }

    public static List<Proveedor> getTodosProveedores() {
        List<Proveedor> proveedors = ProveedorRepository.getAllProveedores();

        return proveedors;
    }
}
