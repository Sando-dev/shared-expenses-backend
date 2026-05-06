package com.bauti.shared_expenses_backend.service;

import com.bauti.shared_expenses_backend.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final List<User> users = new ArrayList<>();
    private int nextId = 1;

    public User createUser(String name) {
        User user = new User(nextId, name);
        users.add(user);
        nextId++;
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }
    
    public boolean deleteUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }
}
