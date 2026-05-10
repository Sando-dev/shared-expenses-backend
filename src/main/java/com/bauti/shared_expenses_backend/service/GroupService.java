package com.bauti.shared_expenses_backend.service;

import com.bauti.shared_expenses_backend.model.Group;
import com.bauti.shared_expenses_backend.repository.GroupRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    
    private final GroupRepository groupRepository;
    private final UserService userService;


    public GroupService(GroupRepository groupRepository, UserService userService) {
        this.groupRepository = groupRepository;
        this.userService = userService;
    }

    public Group createGroup(String name, List<Integer> memberIds) {

        for(Integer memberId : memberIds) {
            if(userService.getUserById(memberId).isEmpty()) {
                throw new IllegalArgumentException("User with id " + memberId + " does not exist");
            }
        }

        Group group = new Group();
        group.setName(name);
        group.setMemberIds(memberIds);
        groupRepository.save(group);
        return group;
    }

    public Optional<Group> getGroupById(int id) {
        return groupRepository.findById(id);
    }

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public boolean deleteGroup(int id) {
        if(groupRepository.existsById(id)) {
            groupRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
