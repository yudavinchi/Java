package org.day7.exercise5;

import org.day7.exercise5.exportToJson.Asset;
import org.day7.exercise5.exportToJson.Group;
import org.day7.exercise5.exportToJson.ToJson;
import org.day7.exercise5.exportToJson.User;

public class Main {
    public static void main(String[] args) {

        User user = new User(123, "David", "password");
        Asset asset = new Asset(321, "David", 100.0);
        Group group = new Group(1, 10);

        user.accept(new ToJson());
    }
}
