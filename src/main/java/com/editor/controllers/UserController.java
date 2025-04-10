package com.editor.controllers;

import com.editor.models.User;
import com.editor.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")  // ✅ Base path for the users API
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println("Received User: " + user.getUsername());  // ✅ Debug print
        return userService.saveUser(user);
    }

}
