package com.es.stockcontrol.repository;

import com.es.stockcontrol.AppStockControl;
import com.es.stockcontrol.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static User findUser(String userName){
        AppStockControl.em.getTransaction().begin();

        User usuario = AppStockControl.em.find(User.class, userName);

        AppStockControl.em.getTransaction().commit();

        return usuario;
    }

    public static User addUser(User user) {
        AppStockControl.em.getTransaction().begin();

        AppStockControl.em.persist(user);

        AppStockControl.em.getTransaction().commit();

        return user;
    }


    public static void deleteUser(User user) {
        AppStockControl.em.getTransaction().begin();

        AppStockControl.em.remove(user);

        AppStockControl.em.getTransaction().commit();
    }
}

