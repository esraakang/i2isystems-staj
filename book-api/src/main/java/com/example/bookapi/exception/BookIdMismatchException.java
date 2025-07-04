package com.example.bookapi.exception;

public class BookIdMismatchException extends RuntimeException {
    public BookIdMismatchException() {
        super("Book ID mismatch");
    }
}
