/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.kata.demo.models;

import java.util.Vector;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 *
 * @author Mekouar Ayoub
 */

@Data
@AllArgsConstructor
public class OperationHistory {
    private Vector<Operation> operations =  new Vector<>();
}
