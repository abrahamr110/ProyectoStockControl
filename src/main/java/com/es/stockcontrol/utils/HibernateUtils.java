package com.es.stockcontrol.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtils {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadMySQL");
    public static EntityManager em = emf.createEntityManager();


}
