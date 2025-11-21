package com.example.SmartExpense.Entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
public class Expense {

    @Id
    private ObjectId id;
    private String catagory;
    @NonNull
    private Double amount;
    private String note;
    private LocalDateTime date;
    private String name;

}