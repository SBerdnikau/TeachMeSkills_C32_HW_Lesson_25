package com.teachmeskills.db;

import com.teachmeskills.model.User;

import java.util.HashMap;
import java.util.Map;

public class UsersDB {
    private final Map<String, User> users;

    public UsersDB() {
        users = new HashMap<>();
        users.put("admin", new User("admin", "123123", "ADMIN"));
        users.put("Sergey", new User("Sergey", "111111", "USER"));
    }

    public User findUser(String name, String password) {
        User user = users.get(name);
        if ( user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
