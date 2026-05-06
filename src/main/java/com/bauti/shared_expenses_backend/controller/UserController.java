package com.bauti.shared_expenses_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bauti.shared_expenses_backend.service.UserService;
import com.bauti.shared_expenses_backend.dto.CreateUserRequest;
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
    public User createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request.getName());
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(int id) {
        Optional<User> user =  userService.getUserById(id);
        if(user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteUser(int id) {
        if(!userService.deleteUser(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
