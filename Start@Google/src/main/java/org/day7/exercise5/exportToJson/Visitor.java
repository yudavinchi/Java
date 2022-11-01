package org.day7.exercise5.exportToJson;

public interface Visitor {
    void visit(Asset asset);

    void visit(Group group);

    void visit(User user);
}

