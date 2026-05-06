package com.bauti.shared_expenses_backend.controller;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Expense> getExpenseById(@PathVariable int id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        if (expense.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expense.get());
    }

    @GetMapping("/groups/{groupId}")
    public ResponseEntity<List<Expense>> getExpensesByGroupId(@PathVariable int groupId) {
        List<Expense> expenses = expenseService.getExpensesByGroupId(groupId);
        if (expenses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expenses);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteExpense(@PathVariable int id) {
        if(expenseService.deleteExpense(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
