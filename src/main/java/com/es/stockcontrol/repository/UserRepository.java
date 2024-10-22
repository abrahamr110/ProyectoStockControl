package com.es.stockcontrol.repository;

import com.es.stockcontrol.AppStockControl;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static User findUser(String userName){
        HibernateUtils.em.getTransaction().begin();

        User usuario = HibernateUtils.em.find(User.class, userName);

        HibernateUtils.em.getTransaction().commit();

        return usuario;
    }

    public static User addUser(User user) {
        HibernateUtils.em.getTransaction().begin();

        HibernateUtils.em.persist(user);

        HibernateUtils.em.getTransaction().commit();

        return user;
    }


    public static void deleteUser(User user) {
        HibernateUtils.em.getTransaction().begin();

        HibernateUtils.em.remove(user);

        HibernateUtils.em.getTransaction().commit();
    }
}

