package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository {

    List<Producto> productos=new ArrayList<>();

    public Producto findProductoById(String id){
        return productos.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }

    public  List<Producto> getAllProductos() {
        return productos;
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public void deleteProducto(Producto producto){
        productos.remove(producto);
    }


}
