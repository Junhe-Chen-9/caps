package com.caps.lexer;


public class NumberToken implements Token{
    // default constructor
    @Override
    public boolean equals(final Object other){
        return other instanceof NumberToken;
    }
    @Override
    public int hashCode(){
        return 20;
    }

    @Override
    public String toString() {
        return "NumberToken{}";
    }
}
