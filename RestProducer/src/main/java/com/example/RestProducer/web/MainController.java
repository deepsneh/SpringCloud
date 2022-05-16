package com.example.RestProducer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/greeting/{username}")
    String greeting(@PathVariable("username") String username) {
        return "Hello :)  " + username;
    }

    @GetMapping("/greeting")
    String greeting() {
        return "Hello :)  Snehal ";
    }
}