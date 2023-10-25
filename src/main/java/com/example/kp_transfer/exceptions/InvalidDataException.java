package com.example.kp_transfer.exceptions;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String msg){
        super(msg);
    }
}