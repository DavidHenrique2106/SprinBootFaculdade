package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/v1/users")
public class UserController {


    @GetMapping("/userIdBody")
    public String getMethodName(@RequestBody String use) {
        return "ResPosta " + use;
    }
    


    
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable String id) {
        return "Cliente numero "+ id;
    }
    


    @GetMapping("/hello")
    public String HelloWorld() {
        return "Hello World Mfk";
    }
    

}
