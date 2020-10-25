package com.example.api.controller;

import com.example.api.model.User;
import com.example.api.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @GetMapping("/users")
    public List<User> allUsers() {
        return userService.findAll();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public void processUser(@PathVariable String id, @RequestBody User user) {
        Long userId = Long.parseLong(id);
        userService.updateUser(userId, user);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/users", consumes = "application/json")
    public User addUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/users/count")
    public Long count() {

        return userService.count();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        userService.deleteById(userId);
    }
}
