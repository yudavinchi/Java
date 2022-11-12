package org.day9.entity;

import java.util.UUID;

public class User {

    private int id;
    private String email;
    private String name;
    private String password;

    public User() {
    }

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
        return new String(email);
    }

    public String getName() {
        return new String(name);
    }

    public String getPassword() {
        return new String(password);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
