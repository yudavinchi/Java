package org.day9.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.day9.entity.User;
import org.day9.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    private Map<String, String> mapUserTokens;

    public AuthService() {
        mapUserTokens = new HashMap<>();
    }

    public void createNewUser(String email, String name, String password) throws IllegalArgumentException {
        User userExist = userRepository.getUserByEmail(email);
        if (userExist != null) {
            throw new IllegalArgumentException("The user already exists");
        }
        User newUser = new User(email, name, password);
        userRepository.writeUserToDb(newUser);
    }

    public String loginUser(String email, String password) {
        User user = userRepository.getUserByEmail(email);
        if (!user.getPassword().equals(password)) {
            throw new NullPointerException("user's email or password don't match");
        }
        String token = generateUniqueToken();
        mapUserTokens.put(token, String.valueOf(user.getId()));
        return token;
    }

    private String generateUniqueToken() {

        StringBuilder token = new StringBuilder();
        long currentTimeInMilisecond = Instant.now().toEpochMilli();

        return token.append(currentTimeInMilisecond).append("-")
                .append(UUID.randomUUID().toString()).toString();
    }

    private Map<String, String> getMapUserTokens() {
        return mapUserTokens;
    }

    public Integer getUserId(String token) throws NullPointerException {
        String id = getMapUserTokens().get(token);

        if (id == null) {
            throw new NullPointerException();
        }
        return Integer.valueOf(id);
    }

    public static void main(String[] args) {
        AuthService authService = new AuthService();
        authService.createNewUser("yudin.david@gmail.com", "david", "321ewqdsacxz");
    }
}