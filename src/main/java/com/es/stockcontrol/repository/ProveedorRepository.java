package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorRepository {
    List<Proveedor> proveedores = new ArrayList<>();

    public Proveedor findProveedorById(Proveedor proveedor){
        return proveedores.stream().filter(p->p.getId().equals(proveedor.getId())).findFirst().orElse(null);
    }

    public void addProveedor(Proveedor proveedor){
        proveedores.add(proveedor);
    }

    public void deleteProveedor(Proveedor proveedor){
        proveedores.remove(proveedor);
    }

    public List<Proveedor> getAllProveedores(){
        return proveedores;
    }

    public void updateProveedor(Proveedor proveedor){
        Proveedor existingProveedor = findProveedorById(proveedor);
        if(existingProveedor != null){
            existingProveedor.setNombre(proveedor.getNombre());
            existingProveedor.setDireccion(proveedor.getDireccion());
        }
    }
}
