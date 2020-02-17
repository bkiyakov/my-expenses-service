package ru.bkiyakov.myexpenses.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bkiyakov.myexpenses.models.Category;
import ru.bkiyakov.myexpenses.models.Expense;
import ru.bkiyakov.myexpenses.models.User;
import ru.bkiyakov.myexpenses.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User getUserById(String userId) {
        return userRepository.getUserByUserId(userId);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public User findById(String userId){
        return userRepository.findById(userId).orElse(null);
    }

    public List<Expense> findUsersExpenses(String userId){
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) return null;

        return user.getExpenses();
    }

    public List<Category> findUsersCategories(String userId){
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) return null;

        return user.getCategories();
    }

    public boolean addExpenseToUser(String userId, Expense expense){
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) return false;

        expense.setExpenseId(new ObjectId());
        user.addExpense(expense);
        userRepository.save(user);
        return true;
    }

    public boolean addCategoryToUser(String userId, Category category){
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) return false;

        category.setCategoryId(new ObjectId());
        user.addCategory(category);
        userRepository.save(user);
        return true;
    }

    public boolean deleteExpense(String userId, String expenseId){
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) return false;

        Expense expense = user.getExpenseById(expenseId);
        if (expense == null) return false;

        if (user.deleteExpense(expense)) {
            userRepository.save(user);
            return true;
        }

        return false;
    }

    //TODO delExp, delCat, changeInfo, editExpense, editCategory
}
