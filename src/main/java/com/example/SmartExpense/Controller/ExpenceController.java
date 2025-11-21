package com.example.SmartExpense.Controller;

import com.example.SmartExpense.Entity.Expense;
import com.example.SmartExpense.Entity.User;
import com.example.SmartExpense.Service.ExpenseService;
import com.example.SmartExpense.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Expence")
public class ExpenceController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @PostMapping("/create-expence")
    public ResponseEntity<?> saveExpence(@RequestBody Expense expense){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        try{
             expenseService.saveExpence(expense,username);
             return new ResponseEntity<>(expense,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-expence")
    public ResponseEntity<?> getAllExpence(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.findByUsername(username);
        List<Expense> all = user.getExpence();
        if(all != null && all.isEmpty()){
            return new ResponseEntity<>(all,HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("get-total")
    public ResponseEntity<?> total(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        Double total = userService.getTotal(username);
        if(total != null && !total.equals("")){
            return new ResponseEntity<>(total,HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
