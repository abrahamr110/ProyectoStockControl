package com.es.stockcontrol.controller.impl;

import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;
import com.es.stockcontrol.service.UserService;

public class UserController implements UserControllerAPI {
    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        RespuestaHTTP<User> logged = UserService.login(userInput, passInput);

        return logged;
    }
}
