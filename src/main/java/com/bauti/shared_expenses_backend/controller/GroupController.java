package com.bauti.shared_expenses_backend.controller;


import com.bauti.shared_expenses_backend.dto.CreateGroupRequest;
import com.bauti.shared_expenses_backend.model.Group;
import com.bauti.shared_expenses_backend.service.GroupService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public Group createGroup(@RequestBody CreateGroupRequest request) {
        return groupService.createGroup(request.getName());
    }

    @GetMapping
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Group> getGroupById(@PathVariable int id) {
        Optional<Group> group = groupService.getGroupById(id);
        if (group.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(group.get());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteGroup(@PathVariable int id) {
        if(!groupService.deleteGroup(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
