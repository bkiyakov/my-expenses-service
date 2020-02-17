package ru.bkiyakov.myexpenses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bkiyakov.myexpenses.models.User;
import ru.bkiyakov.myexpenses.services.UserService;

import java.util.List;

@RequestMapping("/api")
public class RootController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAll();
    }
}
