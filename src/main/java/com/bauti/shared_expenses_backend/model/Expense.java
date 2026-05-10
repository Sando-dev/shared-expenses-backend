package com.bauti.shared_expenses_backend.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses_table")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private int id;
    private String description;
    private double amount;
    private int payerId;
    private List<Integer> participantsId;
    private int groupId;

    public Expense() {

    }

    public Expense(int id, String description, double amount, int payerId, List<Integer> participantsId, int groupId) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.payerId = payerId;
        this.participantsId = participantsId;
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public int getPayer() {
        return payerId;
    }

    public List<Integer> getParticipants() {
        return participantsId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setId(int id) {
        this.id = id;
    }   
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPayer(int payerId) {
        this.payerId = payerId;
    }

    public void setParticipants(List<Integer> participantsId) {
        this.participantsId = participantsId;
    }   

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
