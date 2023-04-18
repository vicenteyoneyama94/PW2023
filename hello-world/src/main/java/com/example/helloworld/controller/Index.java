package com.example.helloworld.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
    
    @GetMapping("/")
    public String hello(){
        return "Ola Mundo Spring, hoje é dia "+new Date();
    }
}
