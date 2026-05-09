package com.bauti.shared_expenses_backend.service;

import com.bauti.shared_expenses_backend.model.Expense;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class ExpenseService {
    
    private final List<Expense> expenses = new ArrayList<>();
    private int nextId = 1;

    private final UserService userService;
    private final GroupService groupService;

    public ExpenseService(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }
    
    public Expense createExpense(String description, double amount, int payerId, List<Integer> participantsId, int groupId) {

        if(userService.getUserById(payerId).isEmpty()) {
            throw new IllegalArgumentException("Payer user does not exist");
        }

        if(groupService.getGroupById(groupId).isEmpty()) {
            throw new IllegalArgumentException("Group does not exist");
        }

        for(Integer participantId : participantsId) {
            if(userService.getUserById(participantId).isEmpty()) {
                throw new IllegalArgumentException("Participant user with id " + participantId + " does not exist");
            }
        }

        Expense expense = new Expense(nextId, description, amount, payerId, participantsId, groupId);
        expenses.add(expense);
        nextId++;
        return expense;
    }

    public Optional<Expense> getExpenseById(int id) {
        return expenses.stream()
                .filter(expense -> expense.getId() == id)
                .findFirst();
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<Expense> getExpensesByGroupId(int groupId) {
        List<Expense> result = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getGroupId() == groupId) {
                result.add(expense);
            }
        }
        return result;
    }

     public boolean deleteExpense(int id) {
        return expenses.removeIf(expense -> expense.getId() == id);
    }
}
