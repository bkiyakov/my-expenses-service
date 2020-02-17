package ru.bkiyakov.myexpenses.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class User {
    public String getUserId() {
        return userId.toString();
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    //Methods to manipulate with user

    public void addExpense(Expense expense){
        expenses.add(expense);
    }

    public boolean deleteExpense(Expense expense){
        boolean res = expenses.remove(expense);

        return res;
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public boolean deleteCategory(Category category){
        boolean res = expenses.remove(category);

        return res;
    }

    public Expense getExpenseById(String expenseId){
        for (Expense expense : expenses){
            if (expense.getExpenseId().equals(expenseId)){
                return expense;
            }
        }

        return null;
    }

    public Category getCategoryById(String categoryId){
        for (Category category : categories){
            if (category.getCategoryId().equals(categoryId)){
                return category;
            }
        }

        return null;
    }

    //TODO changeInfo, editExpense, editCategory

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", userInformation=" + userInformation +
                ", expenses=" + expenses +
                ", categories=" + categories +
                '}';
    }

    @Id
    private ObjectId userId;
    private String username;
    private UserInformation userInformation;
    private List<Expense> expenses = new ArrayList<Expense>();
    private List<Category> categories = new ArrayList<Category>();
}
