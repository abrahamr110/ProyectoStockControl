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

        if (producto != null) {

            return producto.getProveedor();
        }

        HibernateUtils.em.getTransaction().commit();

        return null;
    }
    public static List<Proveedor> getAllProveedores(){
        HibernateUtils.em.getTransaction().begin();

        List<Proveedor> proveedores = HibernateUtils.em.createQuery("SELECT * FROM proveedor", Proveedor.class).getResultList();

        HibernateUtils.em.getTransaction().commit();

        return proveedores;
    }
}
