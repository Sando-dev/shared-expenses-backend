package com.bauti.shared_expenses_backend.controller;

import org.springframework.web.bind.annotation.*;
import com.bauti.shared_expenses_backend.service.UserService;
import com.bauti.shared_expenses_backend.model.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(String name) {
        return userService.createUser(name);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
}
