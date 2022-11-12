package org.day9.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.day9.entity.User;
import org.day9.utils.Files;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private Map<Integer, User> users;   // cache

    private final String BASE_ROUTE = "src/main/java/org/day9/repository/users";

    private static Logger logger = LogManager.getLogger(UserRepository.class.getName());

    public UserRepository() {
        users = new HashMap<>();
        cacheUsersFilesFromRepo();
    }

    public void writeUserToDb(User user) {
        int id = user.getId();

        HashMap<String, String> mapToJson = new HashMap<>();

        mapToJson.put("id", String.valueOf(id));
        mapToJson.put("email", user.getEmail());
        mapToJson.put("name", user.getName());
        mapToJson.put("password", user.getPassword());

        String filename = BASE_ROUTE + "/" + id + ".json";
        Files.writeJsonToFile(filename, mapToJson);
        users.put(user.getId(), user);
    }

    public void removeUserFromDb(int id) {
        String filename = BASE_ROUTE + "/" + id + ".json";
        Files.removeFromFile(filename);
        users.remove(id);
    }

    public User getUserById(Integer id) {
        return users.get(id);
    }

    public User getUserByEmail(String email) {
        for (Integer i : users.keySet()) {
            if (users.get(i).getEmail().equals(email)) {
                return users.get(i);
            }
        }
        return null;
    }

    private void cacheUsersFilesFromRepo() {

        File folder = new File(BASE_ROUTE);
        File[] listOfFiles = folder.listFiles();

        String filename = BASE_ROUTE + "/";

        for (int i = 0; i < listOfFiles.length; i++) {
            HashMap<String, String> fileContent = Files.readFromFile(filename + listOfFiles[i].getName());
            users.put(Integer.valueOf(fileContent.get("id")), new User(fileContent.get("email"), fileContent.get("name"), fileContent.get("password")));
        }
    }
}
