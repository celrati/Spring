package com.example.demo.controller;


/*
*
* Hraf
*
* */


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    String Home(){
        return "hello world";
    }
}
