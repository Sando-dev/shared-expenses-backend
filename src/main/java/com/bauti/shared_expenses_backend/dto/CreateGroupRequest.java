package com.bauti.shared_expenses_backend.dto;

import java.util.List;

public class CreateGroupRequest {
    private String name;
    private List<Integer> memberIds;

    public CreateGroupRequest() {
    }

    public CreateGroupRequest(String name, List<Integer> memberIds) {
        this.name = name;
        this.memberIds = memberIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }
    
    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }
}
