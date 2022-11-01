package org.day7.exercise5.exportToJson;

import com.google.gson.Gson;

import java.util.HashMap;

public class ToJson implements Visitor {

    @Override
    public void visit(Asset asset) {
        HashMap<String, String> temp = new HashMap<>();

        temp.put("serial number", Integer.toString(asset.getSerialNumber()));
        temp.put("owner", asset.getOwner());
        temp.put("rating", Double.toString(asset.getRating()));

        toJson(temp);
    }

    @Override
    public void visit(Group group) {
        HashMap<String, String> temp = new HashMap<>();

        temp.put("id", Integer.toString(group.getId()));
        temp.put("owner", Integer.toString(group.getSize()));

        toJson(temp);
    }

    @Override
    public void visit(User user) {
        HashMap<String, String> temp = new HashMap<>();

        temp.put("id", Integer.toString(user.getId()));
        temp.put("name", user.getName());
        temp.put("password", user.getPassword());

        toJson(temp);
    }

    private void toJson(HashMap<String, String> temp) {
        Gson gson = new Gson();
        String json = gson.toJson(temp);
        System.out.println(json);
    }
}
