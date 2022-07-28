package com.test.restapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @RequestMapping("/greet")
    public String sayHello(){
        return "Hello! this is a rest api application.";
    }
}
