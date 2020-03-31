package com.ddz.demo.Exception;

public class IllegalNameException extends RuntimeException {
    public IllegalNameException(){

    }

    public IllegalNameException(String str){
        super(str);
    }
}
