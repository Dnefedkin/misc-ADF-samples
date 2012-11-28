package com.blogspot.middletier.view.utils;

public class Pair {
    private String code;
    private Object value;
    
    
    
    public Pair() {
        super();
    }
    
    public Pair(String code, Object value) {
        this.code = code;
        this.value = value;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
