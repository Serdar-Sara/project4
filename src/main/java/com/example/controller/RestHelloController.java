package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestHelloController {//controller
	@GetMapping
    public String hello() {
        return " merhaba serdar";
    }

}
