package org.day9.service;

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

    public User register(String email, String name, String password) {

        User userExist = userRepository.getUserByEmail(email);

        if (userExist != null) {
            return null;
        }

        User newUser = new User(email, name, password);
        userRepository.writeUserToDb(newUser);
        return newUser;
    }

    public String login(String email, String password) {

        User user = userRepository.getUserByEmail(email);

        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }

        String token = generateUniqueToken();
        mapUserTokens.put(token, String.valueOf(user.getId()));

        return token;
    }

    private String generateUniqueToken() {

        StringBuilder token = new StringBuilder();
        long currentTimeInMilisecond = Instant.now().toEpochMilli();

        return token.append(currentTimeInMilisecond).append("-").append(UUID.randomUUID()).toString();
    }

    private Map<String, String> getMapUserTokens() {
        return mapUserTokens;
    }

    public Integer getUserId(String token) {

        String id = getMapUserTokens().get(token);

        if (id == null) {
            return null;
        }

        return Integer.valueOf(id);
    }
}