package com.es.stockcontrol.repository;

import com.es.stockcontrol.AppStockControl;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.utils.HibernateUtils;


import java.util.ArrayList;
import java.util.List;


public class ProveedorRepository {

    public static Proveedor getProveedorProducto(String id){
        HibernateUtils.em.getTransaction().begin();

        Producto producto = HibernateUtils.em.find(Producto.class, id);

        HibernateUtils.em.getTransaction().commit();

        if (producto != null) {
            return producto.getProveedor();
        }

        return null;
    }
    public static List<Proveedor> getAllProveedores() {
        HibernateUtils.em.getTransaction().begin();

        List<Proveedor> proveedores = HibernateUtils.em
                .createQuery("SELECT p FROM Proveedor p", Proveedor.class)
                .getResultList();

        HibernateUtils.em.getTransaction().commit();

        return proveedores;
    }

}
