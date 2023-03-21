package com.caps.lexer;

public class AsteriskToken implements Token{
    @Override
    public boolean equals(final Object other){
        return other instanceof AsteriskToken;
    }
    @Override
    public int hashCode(){
        return 11;
    }

    @Override
    public String toString() {
        return "AsteriskToken{}";
    }
}
