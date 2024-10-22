package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.utils.HibernateUtils;

import java.util.List;

public class ProductoRepository {

    public Producto getProducto(String idProducto) {
        HibernateUtils.em.getTransaction().begin();

        Producto producto = HibernateUtils.em.find(Producto.class, idProducto);

        if (producto != null) {
            return producto;
        }

        HibernateUtils.em.getTransaction().commit();

        return null;
    }

    public List<Producto> getProductosConStock() {
        HibernateUtils.em.getTransaction().begin();
        List<Producto> productos = HibernateUtils.em.createQuery("SELECT * FROM Producto WHERE stock > 0", Producto.class).getResultList();
        HibernateUtils.em.getTransaction().commit();
        return productos;
    }

    public List<Producto> getProductosSinStock() {
        HibernateUtils.em.getTransaction().begin();
        List<Producto> productos = HibernateUtils.em.createQuery("SELECT * FROM Producto WHERE stock = 0", Producto.class).getResultList();
        HibernateUtils.em.getTransaction().commit();
        return productos;
    }

    public void altaProducto(String idProducto, String nombreProducto, String precioSinIva, String descripcionProducto,String idProveedor, String nombreProveedor, String direccionProveedor) {
        HibernateUtils.em.getTransaction().begin();

        HibernateUtils.em.getTransaction().commit();
    }

    public void bajaProducto(String idProducto) {
        HibernateUtils.em.getTransaction().begin();
        HibernateUtils.em.remove(HibernateUtils.em.find(Producto.class, idProducto));
        HibernateUtils.em.getTransaction().commit();
    }

    public void modificarProducto(String idProducto, String nuevoNombre) {
        HibernateUtils.em.getTransaction().begin();
        HibernateUtils.em.getTransaction().commit();
    }

    public void modificarStock(String idProducto, String nuevoStock) {
        HibernateUtils.em.getTransaction().begin();
        HibernateUtils.em.getTransaction().commit();
    }

}
