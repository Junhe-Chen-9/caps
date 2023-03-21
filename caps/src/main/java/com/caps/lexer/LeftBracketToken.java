package com.caps.lexer;

public class LeftBracketToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof LeftBracketToken;
    }
    @Override
    public int hashCode(){
        return 17;
    }

    @Override
    public String toString() {
        return "LeftBracketToken{}";
    }
}
