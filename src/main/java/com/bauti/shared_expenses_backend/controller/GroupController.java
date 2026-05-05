package com.bauti.shared_expenses_backend.controller;


import com.bauti.shared_expenses_backend.model.Group;
import com.bauti.shared_expenses_backend.service.GroupService;
import org.springframework.web.bind.annotation.*;

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

}
