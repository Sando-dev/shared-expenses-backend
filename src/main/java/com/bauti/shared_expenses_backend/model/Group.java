package com.bauti.shared_expenses_backend.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "groups_table")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String name;
    private List<Integer> memberIds;

    public Group() {

    }

    public Group(int id, String name, List<Integer> memberIds) {
        this.id = id;
        this.name = name;
        this.memberIds = memberIds;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMemberIds() {
        return memberIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberIds(List<Integer> memberIds) {
        this.memberIds = memberIds;
    }
}
