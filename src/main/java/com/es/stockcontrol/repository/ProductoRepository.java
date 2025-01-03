package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;
import com.es.stockcontrol.model.Proveedor;
import com.es.stockcontrol.utils.HibernateUtils;

import java.util.List;

public class ProductoRepository {

    public static Producto getProducto(String idProducto) {
        HibernateUtils.em.getTransaction().begin();

        Producto producto = HibernateUtils.em.find(Producto.class, idProducto);

        HibernateUtils.em.getTransaction().commit();

        return producto;
    }

    public static List<Producto> getProductosConStock() {
        HibernateUtils.em.getTransaction().begin();

        List<Producto> productos = HibernateUtils.em.createQuery(
                        "SELECT p FROM Producto p WHERE p.stock > 0", Producto.class)
                .getResultList();

        HibernateUtils.em.getTransaction().commit();

        return productos;
    }

    public static List<Producto> getProductosSinStock() {
        HibernateUtils.em.getTransaction().begin();

        List<Producto> productos = HibernateUtils.em.createQuery(
                        "SELECT p FROM Producto p WHERE p.stock = 0", Producto.class)
                .getResultList();

        HibernateUtils.em.getTransaction().commit();

        return productos;
    }

    public static Producto altaProducto(Proveedor proveedor, Producto producto) {
        HibernateUtils.em.getTransaction().begin();

        HibernateUtils.em.persist(proveedor);
        HibernateUtils.em.persist(producto);

        HibernateUtils.em.getTransaction().commit();

        return producto;
    }

    public static void bajaProducto(String idProducto) {
        HibernateUtils.em.getTransaction().begin();

        HibernateUtils.em.remove(HibernateUtils.em.find(Producto.class, idProducto));

        HibernateUtils.em.getTransaction().commit();
    }

    public static void modificarProducto(String idProducto, String nuevoNombre) {
        HibernateUtils.em.getTransaction().begin();

        HibernateUtils.em.createQuery("UPDATE Producto p SET p.nombre = :nuevoNombre WHERE p.id = :id")
                .setParameter("nuevoNombre", nuevoNombre)
                .setParameter("id", idProducto)
                .executeUpdate();

        HibernateUtils.em.getTransaction().commit();
    }

    public static void modificarStock(String idProducto, Integer nuevoStock) {
        HibernateUtils.em.getTransaction().begin();

        HibernateUtils.em.createQuery("UPDATE Producto p SET p.stock = :nuevoStock WHERE p.id = :id")
                .setParameter("nuevoStock", nuevoStock)
                .setParameter("id", idProducto)
                .executeUpdate();

        HibernateUtils.em.getTransaction().commit();
    }

}
