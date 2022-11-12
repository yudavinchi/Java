package org.day9.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.day9.entity.User;
import org.day9.service.AuthService;
import org.day9.service.UserService;
import org.day9.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    private static Logger logger = LogManager.getLogger(UserController.class.getName());

    @RequestMapping(value = "/update-name", method = RequestMethod.GET)
    public ResponseEntity<User> updateName(@RequestHeader("token") String token, @RequestParam("name") String name) {

        try {
            Integer userId = authService.getUserId(token);

            if (!Validate.validateName(name)) {
                return ResponseEntity.badRequest().build();
            }

            User user = userService.updateName(userId, name);
            return ResponseEntity.ok(user);

        } catch (NullPointerException | IllegalArgumentException error) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/update-password", method = RequestMethod.GET)
    public ResponseEntity<User> updatePassword(@RequestHeader("token") String token, @RequestParam("password") String password) {
        try {
            Integer userId = authService.getUserId(token);

            if (!Validate.validatePassword(password)) {
                return ResponseEntity.badRequest().build();
            }

            User user = userService.updatePassword(userId, password);
            return ResponseEntity.ok(user);

        } catch (NullPointerException | IllegalArgumentException error) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/update-email", method = RequestMethod.GET)
    public ResponseEntity<User> updateEmail(@RequestHeader("token") String token, @RequestParam("email") String email) {
        try {
            Integer userId = authService.getUserId(token);

            if (!Validate.validateEmail(email)) {
                return ResponseEntity.badRequest().build();
            }

            User user = userService.updateEmail(userId, email);
            return ResponseEntity.ok(user);

        } catch (NullPointerException | IllegalArgumentException error) {
            return ResponseEntity.badRequest().build();
        }
    }

    @RequestMapping(value = "/remove-user", method = RequestMethod.GET)
    public ResponseEntity<User> removeUser(@RequestHeader("token") String token) {

        try {
            Integer userId = authService.getUserId(token);
            userService.removeUser(userId);

            return ResponseEntity.ok().build();
        } catch (NullPointerException error) {
            return ResponseEntity.notFound().build();
        }
    }
}
