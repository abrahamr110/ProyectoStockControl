package com.es.stockcontrol.repository;

import com.es.stockcontrol.AppStockControl;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.utils.HibernateUtils;


import java.util.ArrayList;
import java.util.List;


public class ProveedorRepository {

    public Proveedor getProveedorProducto(){
        HibernateUtils.em.getTransaction().begin();

        Producto producto = HibernateUtils.em.find(Producto.class, 1);

        if (producto != null) {

            return producto.getProveedor();
        }

        HibernateUtils.em.getTransaction().commit();

        return null;
    }
    public List<Proveedor> getAllProveedores(){
        HibernateUtils.em.getTransaction().begin();

        List<Proveedor> proveedores = HibernateUtils.em.createQuery("SELECT * FROM Proveedor", Proveedor.class).getResultList();

        HibernateUtils.em.getTransaction().commit();

        return proveedores;
    }
}
