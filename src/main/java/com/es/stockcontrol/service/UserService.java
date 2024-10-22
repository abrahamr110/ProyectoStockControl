package com.es.stockcontrol.service;

import com.es.stockcontrol.model.User;
import com.es.stockcontrol.repository.UserRepository;

public class UserService {
    public static User login(String userInput, String passInput) {
        if (!userInput.isBlank() && !passInput.isBlank()) {
            User usuario = UserRepository.findUser(userInput);

            if (usuario != null) {
                if (usuario.getPassword().equals(passInput)) {
                    return usuario;
                }
            }

            return null;
        } else {
            return null;
        }
    }
}
