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
public class OperationService {
    
    public boolean get(){
        return OperationRepository.get();
    }
}
