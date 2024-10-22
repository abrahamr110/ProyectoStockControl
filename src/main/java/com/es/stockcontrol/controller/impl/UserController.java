package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.AppStockControl;
import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserController implements UserControllerAPI {
    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        User usuario = UserService.login(userInput, passInput);

        if (usuario != null) {
            RespuestaHTTP<User> respuestaHTTP = new RespuestaHTTP<>(200, "OK", usuario);

            return respuestaHTTP;
        } else {
            //returnar respuesta correcta
            return null;
        }
    }
}
