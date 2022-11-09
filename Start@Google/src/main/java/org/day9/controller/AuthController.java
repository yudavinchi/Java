package org.day9.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class AuthController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> listVegetables(){
        return ResponseEntity.ok("hello");
    }
}
