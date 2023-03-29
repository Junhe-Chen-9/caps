package com.caps.lexer;

public class StringStartToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof StringStartToken;
    }
    @Override
    public int hashCode(){
        return 28;
    }

    @Override
    public String toString() {
        return "StringStartToken{}";
    }
}
