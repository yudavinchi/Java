package org.day7.day4.exportToJson;

import org.day3.exercise2.Gender;

public interface Visitor {
    void visit(Asset asset);
    void visit(Group group);
    void visit(User user);
}

