package com.example.SmartExpense.Service;

import com.example.SmartExpense.Entity.Expense;
import com.example.SmartExpense.Entity.User;
import com.example.SmartExpense.Repository.ExpenseRepo;
import com.example.SmartExpense.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepo;

    @Autowired
    private UserRepo userRepo;
    public void saveExpence(Expense expense, String username) {
        User user = userRepo.findByUsername(username);
        user.setTotal(user.getTotal()+ expense.getAmount());
        Expense save = expenseRepo.save(expense);
        user.getExpence().add(save);
        userRepo.save(user);
    }


}
