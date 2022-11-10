package org.day9.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.day9.entity.User;
import org.day9.service.AuthService;
import org.day9.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    private static Logger logger = LogManager.getLogger(AuthController.class.getName());

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public void test(String email, String name, String password) throws IllegalArgumentException {
        System.out.println("hello");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(String email, String name, String password) throws IllegalArgumentException {
        logger.trace("enter to registration function");
        boolean isValidateUser = validateUser(email, name, password);

        logger.debug("user validation is: " + isValidateUser);
        if (!isValidateUser) {
            logger.warn("input is not valid, registration failed");
            throw new IllegalArgumentException("input is not valid, registration failed");
        }

        try {
            authService.createNewUser(email, name, password);
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException);
        }
    }

    public String login(String email, String password) throws IllegalArgumentException {
        logger.trace("enter to login function");
        boolean isValidateLoginFields = validateLoginFields(email, password);

        logger.debug("login fields validations are: " + isValidateLoginFields);
        if (!isValidateLoginFields) {
            logger.warn("input is not valid, login failed");
            throw new IllegalArgumentException("input is not valid, login failed");
        }
        return authService.loginUser(email, password);
    }

    private boolean validateUser(String email, String name, String password) {
        logger.trace("enter to validateUser function");
        boolean isEmailValid = Validate.email(email);
        boolean isNameValid = Validate.name(name);
        boolean isPasswordValid = Validate.password(password);

        return isEmailValid && isNameValid && isPasswordValid;
    }


    private boolean validateLoginFields(String email, String password) {
        logger.trace("enter to validateLoginFields function");
        boolean isEmailValid = Validate.email(email);
        boolean isPasswordValid = Validate.password(password);

        return isEmailValid && isPasswordValid;
    }
}
