package com.caps.lexer;

public class StringEndToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof StringEndToken;
    }
    @Override
    public int hashCode(){
        return 29;
    }

    @Override
    public String toString() {
        return "StringEndToken{}";
    }
}
