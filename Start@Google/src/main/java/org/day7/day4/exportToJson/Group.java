package org.day7.day4.exportToJson;

public class Group implements Data{
    private int id, size;

    public Group(int id, int size) {
        this.id = id;
        this.size = size;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
