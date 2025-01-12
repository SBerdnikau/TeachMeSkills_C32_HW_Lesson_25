package com.teachmeskills.model;

public class User  {
    private final String name;
    private final String password;
    private final String role;

    public User(String name, String password, String role ) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
