package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.AppStockControl;
import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserController implements UserControllerAPI {
    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        if (!userInput.isBlank() && !passInput.isBlank()) {
            User usuario = UserRepository.findUser(userInput);

            if (usuario != null) {
                if (usuario.getPassword().equals(passInput)) {
                    return new RespuestaHTTP<User>(200, "OK", usuario);
                } else {
                    return new RespuestaHTTP<User>(403, "Username or password incorrect", null);
                }
            }

            return new RespuestaHTTP<User>(204, "NO CONTENT", null);
        } else {
            return new RespuestaHTTP<User>(400, "Username or password is blank", null);
        }
    }
}
