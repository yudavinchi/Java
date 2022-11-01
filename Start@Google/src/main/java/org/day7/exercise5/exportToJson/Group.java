package org.day7.exercise5.exportToJson;

public class Group implements Data {
    private int id;
    private int size;

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
