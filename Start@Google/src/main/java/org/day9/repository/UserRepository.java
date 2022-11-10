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

    private static Map<Integer, User> users = new HashMap<>();     // cache

    private static final String BASE_ROUTE = "src/main/java/org/day9/repository";

    private static Logger logger = LogManager.getLogger(UserRepository.class.getName());

    public UserRepository(){
        users = new HashMap<>();
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

    public static void removeUserFromDb(int id) {
        logger.trace("enter to writeUserToDb function");
        String filename = BASE_ROUTE + "/" + id + ".json";
        Files.removeFile(filename);

        logger.debug("user with id: " + id + " has been removed");
        users.remove(id);
    }

    public static User getUserById(Integer id) {
        try {
            logger.debug("user with id: " + id + " has been returned");
            return users.get(id);
        } catch (NullPointerException e) {
            logger.warn(e);
        }
        logger.warn("null has been returned");
        return null;
    }

    public static User getUserByEmail(String email) {
        logger.trace("enter to getUserByEmail function");
        for (Integer i : users.keySet()) {
            if (users.get(i).getEmail().equals(email)) {
                logger.debug("user with email: " + email + " has been returned");
                return users.get(i);
            }
        }
        logger.warn("null has been returned");
        return null;
    }

    private static Map<Integer, User> cacheUsersFilesFromRepo() {
        logger.trace("enter to cacheUsersFilesFromRepo function");

        File folder = new File(BASE_ROUTE);
        File[] listOfFiles = folder.listFiles();

        String filename = BASE_ROUTE + "/";

        for (int i = 0; i < listOfFiles.length; i++) {
            HashMap<String, String> fileContent = Files.readFromFile(filename + listOfFiles[i].getName());
            users.put(Integer.valueOf(fileContent.get("id")), new User(fileContent.get("email"), fileContent.get("name"), fileContent.get("password")));
        }
        return users;
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        User user1 = new User("yudin.david@gmail.com", "david", "321ewqdsacxz");
        User user2 = new User("saliman.rany@gmail.com", "rany", "maniak");
        userRepository.writeUserToDb(user1);
        userRepository.writeUserToDb(user2);
    }
}
