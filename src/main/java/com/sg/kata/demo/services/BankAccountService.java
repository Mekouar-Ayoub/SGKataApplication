/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.kata.demo.services;

/**
 *
 * @author Mekouar Ayoub
 */
@Service
public class BankAccountService {

    public boolean save(BankAccount bankAccount) {
        return BankAccountRepository.save(bankAccount);
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

    
}
