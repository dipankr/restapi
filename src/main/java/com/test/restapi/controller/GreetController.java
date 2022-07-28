package com.test.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @GetMapping("/")
    public ResponseEntity<?> success(){
        String msg = "Server up and running: RestAPI";
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(msg);
    }

    @GetMapping("/greet")
    public ResponseEntity<?> sayHello(){
        return ResponseEntity.badRequest().body("Hello! Greetings from the rest api application.");
    }
    @PostMapping
    public ResponseEntity<?> sayHelloWithName(@RequestBody String name){
        return ResponseEntity.ok("Hello "+name+"! Welcome to the rest api application using spring boot");
    }
}
