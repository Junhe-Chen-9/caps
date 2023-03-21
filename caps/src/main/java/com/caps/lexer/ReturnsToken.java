package com.caps.lexer;

public class ReturnsToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof ReturnsToken;
    }
    @Override
    public int hashCode(){
        return 15;
    }

    @Override
    public String toString() {
        return "ReturnsToken{}";
    }
}
