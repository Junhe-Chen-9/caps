package com.caps.lexer;

public class GreaterThanToken implements Token {
    @Override
    public boolean equals(final Object other){
        return other instanceof GreaterThanToken;
    }
    @Override
    public int hashCode(){
        return 27;
    }

    @Override
    public String toString() {
        return "GreaterThanToken{}";
    }
}
