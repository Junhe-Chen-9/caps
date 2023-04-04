package com.caps.parser;

public class GreaterThanOp implements Op{
    @Override
    public boolean equals(final Object other){
        return other instanceof GreaterThanOp;
    }
    @Override
    public int hashCode(){
        return 8;
    }

    @Override
    public String toString() {
        return "GreaterThanOp{}";
    }
}
