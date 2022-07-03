/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.kata.demo.exceptions;

/**
 *
 * @author Mekouar Ayoub
 */
public class NegativeNumberNotSupportedException extends Exception {
    public NegativeNumberNotSupportedException(final String message) {
        super(message);
    }

    public static NegativeNumberNotSupportedException create(float amount) {
        return new NegativeNumberNotSupportedException("Negative value not supported: " + amount);
    }
}
