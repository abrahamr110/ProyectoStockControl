package com.es.stockcontrol.repository;

import com.es.stockcontrol.AppStockControl;
import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;

import java.util.ArrayList;
import java.util.List;

public class ProveedorRepository {

    public Proveedor getProveedorProducto(){
        AppStockControl.em.getTransaction().begin();

        Producto producto = AppStockControl.em.find(Producto.class, 1);

        if (producto != null) {

            return producto.getProveedor();
        }

        AppStockControl.em.getTransaction().commit();

        return null;
    }
    public List<Proveedor> getAllProveedores(){
        AppStockControl.em.getTransaction().begin();

        List<Proveedor> proveedores = AppStockControl.em.createQuery("SELECT * FROM Proveedor", Proveedor.class).getResultList();

        AppStockControl.em.getTransaction().commit();

        return proveedores;
    }
}
