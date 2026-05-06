package com.bauti.shared_expenses_backend.controller;


import com.bauti.shared_expenses_backend.model.Group;
import com.bauti.shared_expenses_backend.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/groups")
    public Group createGroup(@RequestParam String name) {
        return groupService.createGroup(name);
    }

    @GetMapping("/groups")
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/groups/{id}")
    public Optional<Group> getGroupById(@PathVariable int id) {
        return groupService.getGroupById(id);
    }
}
