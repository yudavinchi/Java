package org.day9.entity;

import java.util.UUID;

public class User {

    private int id;
    private String email;
    private String name;
    private String password;

    public User(String email, String name, String password) {
        id = generateUniqueId();
        this.email = email;
        this.name = name;
        this.password = password;
    }

    private int generateUniqueId() {
        return UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
