package org.day9.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.day9.entity.User;
import org.day9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User updateName(Integer id, String name) {
        User user = getUserById(id);

        if (user.getName().equals(name)) {
            return null;
        }

        user.setName(name);
        userRepository.writeUserToDb(user);

        return user;
    }

    public User updateEmail(Integer id, String email) {

        User user = getUserById(id);

        if (user.getEmail().equals(email)) {
            return null;
        }

        user.setEmail(email);
        userRepository.writeUserToDb(user);

        return user;
    }

    public User updatePassword(Integer id, String password) {

        User user = getUserById(id);

        if (user.getPassword().equals(password)) {
            return null;
        }

        user.setPassword(password);
        userRepository.writeUserToDb(user);

        return user;
    }

    public User removeUser(Integer id) {

        User user = getUserById(id);

        if (user == null) {
            return null;
        }

        userRepository.removeUserFromDb(id);
        return user;
    }

    private User getUserById(Integer id) {
        return userRepository.getUserById(id);
    }
}