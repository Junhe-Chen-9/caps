package com.caps.lexer;

public class MinusToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof MinusToken;
    }
    @Override
    public int hashCode(){
        return 7;
    }

    @Override
    public String toString() {
        return "MinusToken{}";
    }
}
