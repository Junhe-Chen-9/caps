package com.caps.lexer;

public class WhileToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof LeftParenToken;
    }
    @Override
    public int hashCode(){
        return 4;
    }

    @Override
    public String toString() {
        return "WhileToken{}";
    }
}