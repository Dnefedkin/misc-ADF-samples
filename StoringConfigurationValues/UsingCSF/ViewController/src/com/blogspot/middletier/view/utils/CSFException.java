package com.blogspot.middletier.view.utils;

public class CSFException extends Exception {
    public CSFException(Throwable throwable) {
        super(throwable);
    }

    public CSFException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public CSFException(String string) {
        super(string);
    }

    public CSFException() {
        super();
    }
}
