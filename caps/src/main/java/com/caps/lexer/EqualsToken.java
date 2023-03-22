package com.caps.lexer;

public class EqualsToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof EqualsToken;
    }
    @Override
    public int hashCode(){
        return 26;
    }
    @Override
    public String toString() {
        return "EqualsToken{}";
    }
}
