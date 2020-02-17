package ru.bkiyakov.myexpenses.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bkiyakov.myexpenses.models.Category;
import ru.bkiyakov.myexpenses.models.Expense;
import ru.bkiyakov.myexpenses.models.User;
import ru.bkiyakov.myexpenses.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/{userId}/expenses")
    public List<Expense> findAllUsersExpenses(@PathVariable String userId){
        return userService.findUsersExpenses(userId);
    }

    @GetMapping("/{userId}/categories")
    public List<Category> findAllUsersCategories(@PathVariable String userId){
        return userService.findUsersCategories(userId);
    }

    @PostMapping("/{userId}/expense")
    public void addExpense(@PathVariable String userId, @RequestBody Expense expense){
        userService.addExpenseToUser(userId, expense);
    }

    @DeleteMapping("/{userId}/expense/{expenseId}")
    public void deleteExpense(@PathVariable String userId, @PathVariable String expenseId){
        userService.deleteExpense(userId, expenseId);
    }
}
