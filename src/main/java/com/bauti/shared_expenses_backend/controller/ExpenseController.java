package com.bauti.shared_expenses_backend.controller;

import org.springframework.web.bind.annotation.*;
import com.bauti.shared_expenses_backend.service.ExpenseService;
import com.bauti.shared_expenses_backend.dto.CreateExpenseRequest;
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
    public Expense createExpense(@RequestBody CreateExpenseRequest request) {

        return expenseService.createExpense(
            request.getDescription(),
            request.getAmount(),
            request.getPayerId(),
            request.getParticipantIds(),
            request.getGroupId()
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
