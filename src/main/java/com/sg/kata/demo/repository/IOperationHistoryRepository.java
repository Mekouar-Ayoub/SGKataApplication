/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.kata.demo.repository;

/**
 *
 * @author Mekouar Ayoub
 */
public interface IOperationHistoryRepository extends MongoRepository<BankAccount, String> {
    
    List<Operation> listAllOperations();
}
