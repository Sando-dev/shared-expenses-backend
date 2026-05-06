package com.bauti.shared_expenses_backend.controller;

import org.springframework.web.bind.annotation.*;
import com.bauti.shared_expenses_backend.service.ExpenseService;
import com.bauti.shared_expenses_backend.model.Expense;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Expense createExpense(
        @RequestParam String description,
        @RequestParam double amount,
        @RequestParam int payerId,
        @RequestParam List<Integer> participantIds,
        @RequestParam int groupId) {

        return expenseService.createExpense(
            description,
            amount,
            payerId, 
            participantIds, 
            groupId
        );
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return expenseService.getExpenses();
    }

    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable int id) {
        return Optional.ofNullable(expenseService.getExpenseById(id));
    }

    @GetMapping("/groups/{groupId}")
    public List<Expense> getExpensesByGroupId(@PathVariable int groupId) {
        return expenseService.getExpensesByGroupId(groupId);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
    }
}
