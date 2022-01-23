package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getEmployees(){
        return "Welcome!";
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET, params = {"page", "size"})
    public Page<User> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "5") int size){
        return userService.getAllById(page, size);
    }


}
