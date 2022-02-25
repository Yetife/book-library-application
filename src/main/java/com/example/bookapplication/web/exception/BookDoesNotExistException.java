package com.example.bookapplication.web.exception;

public class BookDoesNotExistException extends Throwable {
    public BookDoesNotExistException(String s)
    {
        super(s);
    }
}
