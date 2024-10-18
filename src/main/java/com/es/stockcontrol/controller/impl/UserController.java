package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.AppStockControl;
import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserController implements UserControllerAPI {
    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        EntityManager em = AppStockControl.em;
        em.getTransaction().begin();
        System.out.println(userInput);
        User usuario = em.find(User.class, userInput);
        em.getTransaction().commit();
        System.out.println(usuario);
        if (usuario != null) {
            System.out.println(usuario.getPassword());

            //returnar respuesta correcta
            return null;
        } else {
            //returnar respuesta correcta
            return null;
        }
    }
}
