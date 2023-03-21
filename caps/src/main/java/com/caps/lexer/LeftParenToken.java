package com.caps.lexer;

public class LeftParenToken implements Token{

    @Override
    public boolean equals(final Object other){
        return other instanceof LeftParenToken;
    }
    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public String toString() {
        return "LeftParenToken{}";
    }
}
