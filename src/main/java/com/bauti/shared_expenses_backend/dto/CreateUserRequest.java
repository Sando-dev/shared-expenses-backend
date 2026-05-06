package com.bauti.shared_expenses_backend.dto;

public class CreateUserRequest {
    private String name;

    public CreateUserRequest() {
    }

    public CreateUserRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
