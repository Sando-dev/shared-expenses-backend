package com.bauti.shared_expenses_backend.service;

import com.bauti.shared_expenses_backend.model.Expense;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    
    private final List<Expense> expenses = new ArrayList<>();
    private int nextId = 1;

    public Expense createExpense(String description, double amount, int payerId, List<Integer> participantsId, int groupId) {
        Expense expense = new Expense(nextId, description, amount, payerId, participantsId, groupId);
        expenses.add(expense);
        nextId++;
        return expense;
    }

    public Expense getExpenseById(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        return null;
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

     public void deleteExpense(int id) {
        expenses.removeIf(expense -> expense.getId() == id);
    }
}
