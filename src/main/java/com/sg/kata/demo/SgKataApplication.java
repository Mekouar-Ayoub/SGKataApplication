package com.sg.kata.demo;

import com.sg.kata.demo.exceptions.NegativeNumberNotSupportedException;
import com.sg.kata.demo.models.BankAccount;
import com.sg.kata.demo.models.OperationHistory;
import com.sg.kata.demo.models.Operation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgKataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgKataApplication.class, args);
    }
}
