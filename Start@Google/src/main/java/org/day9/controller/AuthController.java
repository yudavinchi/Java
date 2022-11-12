package org.day9.controller;

import org.day9.entity.User;
import org.day9.service.AuthService;
import org.day9.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> register(@RequestBody Map<String, String> map) {

        User temp = new User(map.get("email"), map.get("name"), map.get("password"));

        boolean isValidateUser = Validate.registerFields(temp.getEmail(), temp.getName(), temp.getPassword());

        if (!isValidateUser) {
            return ResponseEntity.badRequest().build();
        }

        User user = authService.register(temp.getEmail(), temp.getName(), temp.getPassword());

        if (user == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(temp);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> login(@RequestBody User temp) {

        if (!Validate.loginFields(temp.getEmail(), temp.getPassword())) {
            return ResponseEntity.notFound().build();
        }

        String token = authService.login(temp.getEmail(), temp.getPassword());

        if (token == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().header("token", token).build();
    }
}