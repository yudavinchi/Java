package org.day7.day4.exportToJson;

public class User implements Data{
    private int id;
    private String name;
    private String password;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
