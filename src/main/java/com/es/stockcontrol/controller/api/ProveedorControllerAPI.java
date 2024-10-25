package com.es.stockcontrol.controller.api;

import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.model.RespuestaHTTP;

import java.util.List;

public interface ProveedorControllerAPI {

    RespuestaHTTP<Proveedor> getProveedorProducto(String idProducto);
    RespuestaHTTP<List<Proveedor>> getTodosProveedores();
}
