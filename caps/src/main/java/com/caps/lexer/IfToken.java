package com.caps.lexer;

public class IfToken implements Token{
    @Override
    public String toString() {
        return "IfToken{}";
    }

    @Override
    public boolean equals(final Object other){
        return other instanceof IfToken;
    }
    @Override
    public int hashCode(){
        return 13;
    }
}
