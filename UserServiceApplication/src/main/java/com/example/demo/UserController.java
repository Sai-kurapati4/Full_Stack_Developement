package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {

        String orders = restTemplate.getForObject(
            "http://localhost:8082/orders/" + id,
            String.class
        );

        return "User ID:" + id + " Name:Sai | Orders: " + orders;
    }
}