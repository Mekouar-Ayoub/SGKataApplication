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

    public boolean deposit(Operation operation) throws NegativeNumberNotSupportedException {
        if (operation.getAmount() < 0.01) {
            throw NegativeNumberNotSupportedException.create(operation.getAmount());
        }
        BankAccount bankAccount = operation.getBankAccount();
        bankAccount.setBalance(bankAccount.getBalance() + operation.getAmount());
        return true;
    }

    public boolean withdrawal(Operation operation) throws NegativeNumberNotSupportedException {
        if (operation.getAmount() < 0.01) {
            throw NegativeNumberNotSupportedException.create(operation.getAmount());
        }
        BankAccount bankAccount = operation.getBankAccount();
        if (bankAccount.getBalance() < operation.getAmount()) {
            return false;
        } else {
            bankAccount.setBalance(bankAccount.getBalance() - operation.getAmount());
            return true;
        }
    }

    public String checkHistory(OperationHistory operationsHistory) {
        //one transaction per line
        if (operationsHistory == null) {
            if (operationsHistory.getOperations() == null) {
                return null;
            }
            return null;
        }
        StringBuilder s = new StringBuilder("");
        for (var x : operationsHistory.getOperations()) {
            s.append(x.toString());
            s.append("\n");
        }
        return s.toString();
    }
}
