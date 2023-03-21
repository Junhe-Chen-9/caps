package com.caps.lexer;

public class RightBracketToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof RightBracketToken;
    }
    @Override
    public int hashCode(){
        return 18;
    }

    @Override
    public String toString() {
        return "RightBracketToken{}";
    }
}
