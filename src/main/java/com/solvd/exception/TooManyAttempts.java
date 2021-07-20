package com.solvd.exception;

public class TooManyAttempts extends Exception{

    public TooManyAttempts(){
        super();
    }

    @Override
    public String getMessage(){
        return "=======================\n" +
                "Too many attempts." +
                "\n=======================";
    }

}
