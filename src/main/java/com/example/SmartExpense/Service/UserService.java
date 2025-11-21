package com.example.SmartExpense.Service;

import com.example.SmartExpense.Entity.User;
import com.example.SmartExpense.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public void newUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setTotal(0.0);
        userRepo.save(user);
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    public Double getTotal(String username) {
        User user = userRepo.findByUsername(username);
        return user.getTotal();
    }
}
