package com.bauti.shared_expenses_backend.service;

import com.bauti.shared_expenses_backend.model.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    
    private final List<Group> groups = new ArrayList<>();
    private int nextId = 1;

    public Group createGroup(String name, List<Integer> memberIds) {
        Group group = new Group(nextId, name, memberIds);
        groups.add(group);
        nextId++;
        return group;
    }

    public Optional<Group> getGroupById(int id) {
        return groups.stream()
                .filter(group -> group.getId() == id)
                .findFirst();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public boolean deleteGroup(int id) {
        return groups.removeIf(group -> group.getId() == id);
    }

}
