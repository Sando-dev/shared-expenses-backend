package com.bauti.shared_expenses_backend.dto;

import java.util.List;

public class CreateExpenseRequest {
    
    private String description;
    private double amount;
    private int payerId;
    private List<Integer> participantIds;
    private int groupId;

    public CreateExpenseRequest() {
    }

    public CreateExpenseRequest(String description, double amount, int payerId, int groupId) {
        this.description = description;
        this.amount = amount;
        this.payerId = payerId;
        this.groupId = groupId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public List<Integer> getParticipantIds() {
        return participantIds;
    }

    public void setParticipantIds(List<Integer> participantIds) {
        this.participantIds = participantIds;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

}
