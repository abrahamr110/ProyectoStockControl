package com.es.stockcontrol.repository;

import com.es.stockcontrol.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users = new ArrayList<>();

    public User findUser(User user){
        return users.stream().filter(u -> u.getNombre_usuario().equals(user.getNombre_usuario())).findFirst().orElse(null);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void updateUser(User user){
        User existingUser = findUser(user);
        if (existingUser != null) {
            existingUser.setPassword(user.getPassword());
            existingUser.setNombre_usuario(user.getNombre_usuario());
        }
    }
}

