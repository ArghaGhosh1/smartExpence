package com.example.SmartExpense.Repository;

import com.example.SmartExpense.Entity.Expense;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepo extends MongoRepository<Expense, ObjectId> {
}
