package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.ProveedorControllerAPI;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.service.ProveedorService;

import java.util.List;

public class ProveedorController implements ProveedorControllerAPI {
    @Override
    public RespuestaHTTP<Proveedor> getProveedorProducto(String idProducto) {
        RespuestaHTTP<Proveedor> proveedorRespuestaHTTP = ProveedorService.getProveedorProducto(idProducto);

        return proveedorRespuestaHTTP;
    }

    @Override
    public RespuestaHTTP<List<Proveedor>> getTodosProveedores() {
        return null;
    }
}
