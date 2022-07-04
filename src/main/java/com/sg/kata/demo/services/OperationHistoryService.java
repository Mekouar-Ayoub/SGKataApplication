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
public class OperationHistoryService {
    
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
