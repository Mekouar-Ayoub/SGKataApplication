/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.kata.demo.models;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Mekouar Ayoub
 */
@Data
@AllArgsConstructor
public class Operation {
    private float amount;
    private LocalDate date;
    private BankAccount bankAccount;
    private OperationType transactionType;
}
